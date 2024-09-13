package com.eventotec.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventotec.api.domain.cliente.Cliente;

public interface ClienteRepository extends JpaRepository <Cliente, Integer>{
    
}
