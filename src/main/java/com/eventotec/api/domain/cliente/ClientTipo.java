package com.eventotec.api.domain.cliente;

import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "client_tipo")
public class ClientTipo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cltpId;

    @Column(nullable = false, length = 40)
    private String dstipo;

    @Column(nullable = false, precision = 1)
    private int icpessoajuridica;

    @Column(nullable = false, precision = 1)
    private int icuso;

    @Column(name = "cliente__tipo_ultimaatualizacao", nullable = false, columnDefinition = "timestamp default current_timestamp")
    private LocalDateTime ultimaAtualizacao;

    // Getters and Setters

    public Integer getCltpId() {
        return cltpId;
    }

    public void setCltpId(Integer cltpId) {
        this.cltpId = cltpId;
    }

    public String getDstipo() {
        return dstipo;
    }

    public void setDstipo(String dstipo) {
        this.dstipo = dstipo;
    }

    public int getIcpessoajuridica() {
        return icpessoajuridica;
    }

    public void setIcpessoajuridica(int icpessoajuridica) {
        this.icpessoajuridica = icpessoajuridica;
    }

    public int getIcuso() {
        return icuso;
    }

    public void setIcuso(int icuso) {
        this.icuso = icuso;
    }

    public LocalDateTime getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public void setUltimaAtualizacao(LocalDateTime ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }
}
