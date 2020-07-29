package com.tandem.message.controller;

import javax.servlet.http.HttpServletRequest;

import com.tandem.message.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import com.tandem.message.dto.RequestAuthDto;
import com.tandem.message.config.response.SuccessResponse;
import com.tandem.message.service.UserService;

@RestController
@RequestMapping("/auth")
@Api(tags = "Authentication")
public class AuthController {

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "${AuthController.login}")
    public SuccessResponse<String> userLogin(
            HttpServletRequest request,
            @ApiParam("Login User") @RequestBody RequestAuthDto input) {

        return new SuccessResponse<>(
                userService.login(input.getEmail(), input.getPassword())
        );
    }
}