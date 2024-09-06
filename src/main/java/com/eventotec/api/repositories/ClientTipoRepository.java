package com.eventotec.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventotec.api.domain.cliente.ClientTipo;

public interface ClientTipoRepository extends JpaRepository <ClientTipo, Integer>{

    
} 