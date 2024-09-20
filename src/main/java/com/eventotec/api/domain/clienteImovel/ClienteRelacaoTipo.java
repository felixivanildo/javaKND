package com.eventotec.api.domain.clienteImovel;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class ClienteRelacaoTipo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_relacao_tipo_crtp_id_seq")
    @SequenceGenerator(name = "cliente_relacao_tipo_crtp_id_seq", sequenceName = "cliente_relacao_tipo_crtp_id_seq", allocationSize = 1)
    @Column(name = "crtp_id")
    private Integer crtpId;

    @Column(name = "crtp_dsrelacao", length = 20, nullable = false)
    private String dsRelacao;

    @Column(name = "crtp_icuso", precision = 1, scale = 0)
    private Integer icUso;

    @Column(name = "crtp_ultima_atualizacao", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime ultimaAtualizacao;

    // Getters and Setters
    public Integer getCrtpId() {
        return crtpId;
    }

    public void setCrtpId(Integer crtpId) {
        this.crtpId = crtpId;
    }

    public String getDsRelacao() {
        return dsRelacao;
    }

    public void setDsRelacao(String dsRelacao) {
        this.dsRelacao = dsRelacao;
    }

    public Integer getIcUso() {
        return icUso;
    }

    public void setIcUso(Integer icUso) {
        this.icUso = icUso;
    }

    public LocalDateTime getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public void setUltimaAtualizacao(LocalDateTime ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    } 
}
