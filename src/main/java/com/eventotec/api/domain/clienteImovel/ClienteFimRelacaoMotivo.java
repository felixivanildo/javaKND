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
@Table(name = "clie_fim_relacao_motivo")
public class ClienteFimRelacaoMotivo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clie_fim_relacao_motivo_cfrm_id_seq")
    @SequenceGenerator(name = "clie_fim_relacao_motivo_cfrm_id_seq", sequenceName = "clie_fim_relacao_motivo_cfrm_id_seq", allocationSize = 1)
    @Column(name = "cfrm_id")
    private Integer cfrmId;

    @Column(name = "cfrm_dsmotivo", length = 30, nullable = false)
    private String dsMotivo;

    @Column(name = "cfrm_icuso", precision = 1, scale = 0, nullable = false)
    private Integer icUso;

    @Column(name = "cfrm_ultima_atualizacao", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime ultimaAtualizacao;

    // Getters and Setters
    public Integer getCfrmId() {
        return cfrmId;
    }

    public void setCfrmId(Integer cfrmId) {
        this.cfrmId = cfrmId;
    }

    public String getDsMotivo() {
        return dsMotivo;
    }

    public void setDsMotivo(String dsMotivo) {
        this.dsMotivo = dsMotivo;
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
