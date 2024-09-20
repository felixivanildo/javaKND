package com.eventotec.api.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventotec.api.domain.cliente.ClientTipo;
import com.eventotec.api.domain.cliente.Cliente;
import com.eventotec.api.domain.cliente.ClienteRequestDTO;
import com.eventotec.api.domain.cliente.ClienteUpdateDTO;
import com.eventotec.api.repositories.ClienteRepository;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;


    @Autowired
    private ClienteTipoService clienteTipoService;

    public Cliente creaCliente (ClienteRequestDTO data){

        Cliente newCliente = new Cliente();

        final ClientTipo clientTipo = clienteTipoService.findClientTipoId(data.cltp_id());

        newCliente.setClientTipo(clientTipo);
        newCliente.setCodigoClienteResponsavel(data.clie_cdclienteresponsavel());
        newCliente.setCpfCnpj(data.cpf_cnpj());
        newCliente.setNomeCliente(data.nm_cliente());
        newCliente.setNomeMae(data.nome_mae());
        newCliente.setUsuarioId(data.usuario_id());
        newCliente.setUltimaAtualizacao(LocalDate.now());


        return clienteRepository.save(newCliente);
    }


    public Cliente updateCliente (ClienteUpdateDTO data){

        Optional<Cliente> existCliente =  clienteRepository.findById(data.id());
        final ClientTipo clientTipo = clienteTipoService.findClientTipoId(data.cltp_id());

        if (existCliente.isPresent()) {
            Cliente exCliente = existCliente.get();

            exCliente.setClientTipo(clientTipo);
            exCliente.setCodigoClienteResponsavel(data.clie_cdclienteresponsavel());
            exCliente.setCpfCnpj(data.cpf_cnpj());
            exCliente.setNomeCliente(data.nm_cliente());
            exCliente.setNomeMae(data.nome_mae());
            exCliente.setUsuarioId(data.usuario_id());

            return clienteRepository.save(exCliente);
        }
        else{
            return null;
        }        

    }


    public List<Cliente> listCliente (){
        return clienteRepository.findAll();
    }


    public Cliente listClientesId (Integer id) {
        Optional<Cliente> existCliente = clienteRepository.findById(id);
        
        if(existCliente.isPresent()){
            return existCliente.get();
        }
         throw new RuntimeException("ClientTipo not found for id: " + id);
    }

    public void deleteCliente (Integer id){
        clienteRepository.deleteById(id);
    }

}
