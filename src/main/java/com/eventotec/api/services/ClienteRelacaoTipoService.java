package com.eventotec.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventotec.api.domain.clienteImovel.ClienteRelacaoTipo;
import com.eventotec.api.repositories.ClienteRelacaoTipoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteRelacaoTipoService {

    @Autowired
    private ClienteRelacaoTipoRepository clienteRelacaoTipoRepository;

    public List<ClienteRelacaoTipo> findAll (){
        return clienteRelacaoTipoRepository.findAll();
    }


    public ClienteRelacaoTipo findRelacaoTipoById(Integer id){
        Optional<ClienteRelacaoTipo> cOptional = clienteRelacaoTipoRepository.findById(id);

        if(cOptional.isPresent()){
            return cOptional.get();
        }

        throw new RuntimeException("Relacao tipo not found for id: " + id);
    }
}
