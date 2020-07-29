package com.tandem.message.config.controlleradvice;

import com.tandem.message.exception.CustomException;
import com.tandem.message.exception.ValidationException;
import com.tandem.message.exception.UserRestrictedException;
import com.tandem.message.config.response.ErrorResponse;
import org.hibernate.exception.GenericJDBCException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionAdvice {
    @Value("${stacktrace}")
    boolean stackTrace;


    @ExceptionHandler({UsernameNotFoundException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ErrorResponse<Object> processAuthorizationError(final Exception ex) {
        List<StackTraceElement> ele = null;
        if (stackTrace == true) {
            ele = Arrays.asList(ex.getStackTrace());
        }
        ErrorResponse<Object> response = new ErrorResponse<>(ele, "Invalid username/password");
        return response;
    }

    @ExceptionHandler(value = {CustomException.class})
    public ResponseEntity<Object> customExceptionHandler(CustomException ex) {
        List<StackTraceElement> ele = null;
        if (stackTrace == true) {
            ele = Arrays.asList(ex.getStackTrace());
        }
        ErrorResponse<Object> response = new ErrorResponse<>(ele, ex.getMessage());
        return new ResponseEntity<>(response, ex.getHttpStatus());
    }

    @ExceptionHandler(UserRestrictedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    public ErrorResponse<List<StackTraceElement>> processForbiddenError(Exception ex) {
        List<StackTraceElement> ele = null;
        if (stackTrace == true) {
            ele = Arrays.asList(ex.getStackTrace());
        }
        return new ErrorResponse<>(ele, ex.getMessage());
    }

    @ExceptionHandler({InvalidParameterException.class, RuntimeException.class, GenericJDBCException.class, ValidationException.class, MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse<List<StackTraceElement>> processValidationError(Exception ex) {
        List<StackTraceElement> ele = null;

        if (stackTrace == true) {
            ele = Arrays.asList(ex.getStackTrace());
        }

        String message = ex.getMessage();

        if (ex instanceof MethodArgumentNotValidException) {
            message = ((MethodArgumentNotValidException) ex).
                    getBindingResult()
                    .getAllErrors()
                    .stream().map((e) -> e.getDefaultMessage() + ", ").collect(Collectors.joining());
        }

        ErrorResponse<List<StackTraceElement>> response = new ErrorResponse<>(ele, message);
        return response;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResponse<List<StackTraceElement>> processAllError(Exception ex) {
        List<StackTraceElement> ele = null;
        if (stackTrace == true) {
            ele = Arrays.asList(ex.getStackTrace());
        }
        ErrorResponse<List<StackTraceElement>> response = new ErrorResponse<>(ele, ex.getMessage());
        return response;
    }
}