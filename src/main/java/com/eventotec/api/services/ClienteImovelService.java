package com.eventotec.api.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventotec.api.domain.cliente.Cliente;
import com.eventotec.api.domain.clienteImovel.ClienteImovel;
import com.eventotec.api.domain.clienteImovel.ClienteImovelRequestDTO;
import com.eventotec.api.domain.clienteImovel.ClienteRelacaoTipo;
import com.eventotec.api.domain.imov.Imovel;
import com.eventotec.api.repositories.ClienteImovelRepository;

@Service
public class ClienteImovelService {
    
    @Autowired
    ClienteImovelRepository clienteImovelRepository;

    @Autowired
    ImovelService imovelService;

    @Autowired
    ClienteService clienteService;

    @Autowired
    ClienteRelacaoTipoService clienteRelacaoTipoService;

    public ClienteImovel createClienteImovel (ClienteImovelRequestDTO data) {

        ClienteImovel clienteImovel = new ClienteImovel();

        final Cliente cliente = clienteService.listClientesId(data.cliente_id());
        final Imovel imovel =  imovelService.getallImovelByid(data.imovel_id());
        final ClienteRelacaoTipo clienteRelacaoTipo = clienteRelacaoTipoService.findRelacaoTipoById(data.crtp_id());


        

        clienteImovel.setCliente(cliente);
        clienteImovel.setImovel(imovel);
        clienteImovel.setIcNomeConta(data.clie_icnomeconta());
        clienteImovel.setUltimaAtualizacao(LocalDate.now());
        clienteImovel.setDtInicioRelacao(data.climov_dtiniciorelacao());
        clienteImovel.setRelacaoTipo(clienteRelacaoTipo);


        return  clienteImovelRepository.save(clienteImovel);

    }


    public List<ClienteImovel> listAllClienteImoveis () {
        return clienteImovelRepository.findAll();
    }
}
