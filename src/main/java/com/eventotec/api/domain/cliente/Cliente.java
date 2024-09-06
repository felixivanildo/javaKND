package com.eventotec.api.domain.cliente;

import javax.persistence.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "cliente")
public class Cliente {

   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id", nullable = false)
    private Integer clienteId;

    @Column(name = "clie_cdclienteresponsavel", length = 40)
    private String codigoClienteResponsavel;

    @Column(name = "nm_cliente", length = 40, nullable = false)
    private String nomeCliente;

    @Column(name = "cpf_cnpj", length = 20)
    private String cpfCnpj;

    @Column(name = "nome_mae", length = 40)
    private String nomeMae;

    @Column(name = "cliente_ultimaatualizacao", nullable = false, columnDefinition = "timestamp default current_timestamp")
    private Timestamp ultimaAtualizacao;

    @Column(name = "usuario_id")
    private UUID usuarioId;

    @ManyToOne
    @JoinColumn(name = "cltp_id", referencedColumnName = "cltp_id")
    private ClientTipo clientTipo;

    // Getters and Setters

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public String getCodigoClienteResponsavel() {
        return codigoClienteResponsavel;
    }

    public void setCodigoClienteResponsavel(String codigoClienteResponsavel) {
        this.codigoClienteResponsavel = codigoClienteResponsavel;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public Timestamp getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public void setUltimaAtualizacao(Timestamp ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }

    public UUID getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(UUID usuarioId) {
        this.usuarioId = usuarioId;
    }

    public ClientTipo getClientTipo() {
        return clientTipo;
    }

    public void setClientTipo(ClientTipo clientTipo) {
        this.clientTipo = clientTipo;
    }
}