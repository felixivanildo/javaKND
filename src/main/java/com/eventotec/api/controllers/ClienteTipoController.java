package com.eventotec.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventotec.api.domain.cliente.ClientTipo;
import com.eventotec.api.services.ClienteTipoService;

@RestController
@RequestMapping("/api/cliente/tipo")
public class ClienteTipoController {

    @Autowired
    private ClienteTipoService clienteTipoService;

    @GetMapping
    public ResponseEntity getClientTipo(){
        List<ClientTipo> clientTipos = clienteTipoService.listClientTipos();

        return ResponseEntity.ok(clientTipos);
    }
}
