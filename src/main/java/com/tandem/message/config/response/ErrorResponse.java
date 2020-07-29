package com.tandem.message.config.response;

import com.tandem.message.dto.common.ErrorDto;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse<T> {

    private ErrorDto<T> error;

    public ErrorResponse(T object, String message) {
        error = new ErrorDto<T>(object, message);
    }

    public ErrorDto<T> getError() {
        return error;
    }

    public void setError(ErrorDto<T> error) {
        this.error = error;
    }
}