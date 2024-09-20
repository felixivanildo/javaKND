package com.eventotec.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventotec.api.domain.clienteImovel.ClienteImovel;

public interface ClienteImovelRepository extends JpaRepository <ClienteImovel, Integer>{
    
}
