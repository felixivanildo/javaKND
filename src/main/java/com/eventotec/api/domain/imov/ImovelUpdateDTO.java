package com.eventotec.api.domain.imov;

public record ImovelUpdateDTO(Integer id, String rua, String numero_casa, String bloco, String descricao, String andar, Long ic_exclusao) {
    
}
