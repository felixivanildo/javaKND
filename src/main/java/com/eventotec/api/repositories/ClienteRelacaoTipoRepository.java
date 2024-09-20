package com.eventotec.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventotec.api.domain.clienteImovel.ClienteRelacaoTipo;

public interface ClienteRelacaoTipoRepository extends JpaRepository<ClienteRelacaoTipo, Integer> {
}
