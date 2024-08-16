package com.eventotec.api.controllers;

import com.eventotec.api.domain.user.User;
import com.eventotec.api.domain.user.UserRequestDTO;
import com.eventotec.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;
    

    @PostMapping
    public ResponseEntity<User> create(@RequestBody UserRequestDTO data) {
        User newUser = userService.createUsr(data);

        // System.out.println("newUser");
        return ResponseEntity.ok(newUser);
    }


    @GetMapping("/consultar")
    public ResponseEntity<List<User>> listAllUsers() {
        List<User> users = userService.listUser();
        return ResponseEntity.ok(users);
    }
}
