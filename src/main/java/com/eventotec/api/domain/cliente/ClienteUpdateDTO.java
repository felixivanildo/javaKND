package com.eventotec.api.domain.cliente;

import java.util.UUID;

public record ClienteUpdateDTO(Integer id, String clie_cdclienteresponsavel, String nm_cliente, String cpf_cnpj, String nome_mae, Integer cltp_id, UUID usuario_id) {
    
}
