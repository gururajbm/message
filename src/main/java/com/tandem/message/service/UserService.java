package com.tandem.message.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tandem.message.repo.UserRepository;
import com.tandem.message.entity.User;
import com.tandem.message.security.JwtTokenProvider;
import com.tandem.message.exception.CustomException;
import com.tandem.message.dto.ResponseAuthDto;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    public String login(String email, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
            return jwtTokenProvider.createToken(email);

        } catch (AuthenticationException e) {
            System.out.print(e.getMessage());
            throw new UsernameNotFoundException("Email '" + email + "' not found");
        }
    }
}
