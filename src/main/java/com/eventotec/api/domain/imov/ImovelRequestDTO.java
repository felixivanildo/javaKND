package com.eventotec.api.domain.imov;

public record ImovelRequestDTO(String rua, String numero_casa, String bloco, String descricao, String andar, Long ic_exclusao) {
} 