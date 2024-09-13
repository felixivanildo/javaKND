package com.eventotec.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eventotec.api.domain.cliente.ClientTipo;

import com.eventotec.api.repositories.ClientTipoRepository;

@Service
public class ClienteTipoService {
    
    @Autowired
    private ClientTipoRepository clientTipoRepository;

    public List<ClientTipo> listClientTipos (){
        return clientTipoRepository.findAll();
    }

    public ClientTipo findClientTipoId(Integer id) {
        Optional<ClientTipo> optionalClientTipo = clientTipoRepository.findById(id);
        if (optionalClientTipo.isPresent()) {
            return optionalClientTipo.get();
        } else {
            throw new RuntimeException("ClientTipo not found for id: " + id); // You can use a custom exception here
        }
    }
}
