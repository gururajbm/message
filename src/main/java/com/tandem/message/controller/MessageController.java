package com.tandem.message.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/message")
public class MessageController {

    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public String UserMessages(HttpServletRequest request) {
        return "hello";
    }
}
