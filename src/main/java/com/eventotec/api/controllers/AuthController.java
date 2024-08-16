package com.eventotec.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventotec.api.domain.auth.AuthDTO;
import com.eventotec.api.domain.user.User;
import com.eventotec.api.security.token.TokenService;

import ch.qos.logback.core.subst.Token;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private TokenService tokenService;
    

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthDTO data){

        
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.username(), data.password());
        // System.out.println(usernamePassword);

        try {
            var auth = this.authenticationManager.authenticate(usernamePassword);

            var token = tokenService.generateToken((User) auth.getPrincipal());

            return ResponseEntity.ok(token);
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(401).build();
        }
        

    }
}
