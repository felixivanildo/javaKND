package com.eventotec.api.domain.user;

public record UserRequestDTO(String nome, String password, String description, String cargo, String email, UserRole admin ) {
}