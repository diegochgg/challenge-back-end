package com.pichincha.challengebackend.authentication.controller;

import com.pichincha.challengebackend.authentication.dto.UserCredentials;
import com.pichincha.challengebackend.authentication.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {

    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> login(@RequestBody UserCredentials credentials) {
        return ResponseEntity.ok(jwtProvider.generateToken(credentials.getUsername()));
    }

}
