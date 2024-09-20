package com.eventotec.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventotec.api.domain.clienteImovel.ClienteImovel;
import com.eventotec.api.domain.clienteImovel.ClienteImovelRequestDTO;
import com.eventotec.api.domain.imov.Imovel;
import com.eventotec.api.services.ClienteImovelService;

@RestController
@RequestMapping("/clienteImovel")
public class ClienteImovelController {
    @Autowired ClienteImovelService clienteImovelService;

    @PostMapping("/relacionar")
    public ResponseEntity insertClienteImovel (@RequestBody ClienteImovelRequestDTO data){

        ClienteImovel clienteImovel = clienteImovelService.createClienteImovel(data);

        return ResponseEntity.ok(clienteImovel);
    }


    @GetMapping("/consultar")
    public ResponseEntity<List<ClienteImovel>> getAllImoveis () {
        return ResponseEntity.ok(clienteImovelService.listAllClienteImoveis());
    }


}
