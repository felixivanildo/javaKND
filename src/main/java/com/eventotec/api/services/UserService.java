package com.eventotec.api.services;


import com.eventotec.api.domain.user.User;
import com.eventotec.api.domain.user.UserRequestDTO;
import com.eventotec.api.repositories.UserRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createUsr (UserRequestDTO data){
      

        User newUsr = new User();

        newUsr.setNome(data.nome());
        newUsr.setCargo(data.cargo());
        newUsr.setEmail(data.email());
        newUsr.setDescription(data.description());
        newUsr.setDate(LocalDate.now());
        newUsr.setPassword(passwordEncoder.encode(data.password()));
        newUsr.setAdmin(data.admin());

        return userRepository.save(newUsr);
    }



   // private String passwordEncoder(String password) {
  //      return new BCryptPasswordEncoder().toString();

   // }

    public List<User> listUser(){
        return userRepository.findAll();
    }
    
    public UserDetails findUserById(UUID id){
        return userRepository.findAllById(id);
    }


    @Transactional
    public void deleteUserById(UUID id){
        userRepository.deleteById(id);
    }
 
}
