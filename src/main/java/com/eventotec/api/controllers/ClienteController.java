package com.eventotec.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventotec.api.domain.cliente.Cliente;
import com.eventotec.api.domain.cliente.ClienteFindDTO;
import com.eventotec.api.domain.cliente.ClienteRequestDTO;
import com.eventotec.api.domain.cliente.ClienteUpdateDTO;
import com.eventotec.api.services.ClienteService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @PostMapping("/criar")
    public ResponseEntity<Cliente> createCliente(@RequestBody ClienteRequestDTO data){
        Cliente newCliente = clienteService.creaCliente(data);

        return ResponseEntity.ok(newCliente);

    }

    @GetMapping("/consultar")
    public ResponseEntity<List<Cliente>> listClient(){
        List <Cliente> clientes = clienteService.listCliente();

        return ResponseEntity.ok(clientes);

    }

    @PostMapping("/consultar/id")
    public ResponseEntity<Cliente> listClienteId (@RequestBody ClienteFindDTO data){
        Cliente clientes = clienteService.listClientesId(data.id());

        return ResponseEntity.ok(clientes);

    }

    @PostMapping("/deletar")
    public ResponseEntity<Map<String, String>> deleteCliente (@RequestBody ClienteFindDTO data){
        
        clienteService.deleteCliente(data.id());
        Map<String, String> response = new HashMap<>();
        response.put("MESSAGE", "DELETED");
        

        return  ResponseEntity.ok(response);
    }

    @PutMapping("/atualizar")
    public ResponseEntity updateCliente (@RequestBody ClienteUpdateDTO data){

        Cliente cliente = clienteService.updateCliente(data);

        return ResponseEntity.ok(cliente);
    }
    
}
