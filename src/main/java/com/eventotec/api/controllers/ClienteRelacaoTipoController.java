package com.eventotec.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eventotec.api.domain.clienteImovel.ClienteRelacaoTipo;

import com.eventotec.api.services.ClienteRelacaoTipoService;

@RestController
@RequestMapping("/clienterelacaotipo")
public class ClienteRelacaoTipoController {
    
    @Autowired
    ClienteRelacaoTipoService clienteRelacaoTipoService;

    


    @GetMapping("/listar")
    public ResponseEntity listRelacaoTipo(){
        List<ClienteRelacaoTipo> clienteRelacaoList = clienteRelacaoTipoService.findAll();

        return ResponseEntity.ok(clienteRelacaoList);
    }

}
