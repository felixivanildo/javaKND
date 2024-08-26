package com.eventotec.api.domain.user;

public record UserUpdateDTO(String Id, String nome, String password, String description, String cargo, String email, UserRole admin ) {
}