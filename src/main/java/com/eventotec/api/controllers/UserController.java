package com.eventotec.api.controllers;

import com.eventotec.api.domain.user.User;
import com.eventotec.api.domain.user.UserRequestDTO;
import com.eventotec.api.domain.user.UserUpdateDTO;
import com.eventotec.api.repositories.UserRepository;
import com.eventotec.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;
    

    @PostMapping("/inserir")
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


    @PutMapping("/atualizar")
    public ResponseEntity updateUser(@RequestBody UserUpdateDTO data) {
        
        final UUID id = UUID.fromString(data.Id());
        UserDetails users = userService.findUserById(id);
        return ResponseEntity.ok(users);
    }


    @PutMapping("/deletar")
    public ResponseEntity putMethodName(@RequestBody UserUpdateDTO data) {
        final UUID id = UUID.fromString(data.Id());


        userService.deleteUserById(id);
        Map<String, String> response = new HashMap<>();
        response.put("MESSAGE", "DELETED");
        

        return  ResponseEntity.ok(response);
    }
}
