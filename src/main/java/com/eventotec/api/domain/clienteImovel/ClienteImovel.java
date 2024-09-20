package com.eventotec.api.domain.clienteImovel;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.eventotec.api.domain.cliente.Cliente;
import com.eventotec.api.domain.imov.Imovel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name =  "cliente_imovel")
public class ClienteImovel {
    

    @Id
    @GeneratedValue(strategy =  GenerationType.SEQUENCE, generator = "cliente_imovel_climov_id_seq" )
    @SequenceGenerator(name = "cliente_imovel_climov_id_seq", sequenceName = "cliente_imovel_climov_id_seq", allocationSize = 1)
    @Column(name = "climov_id")
    private Integer climovId;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "imovel_id", nullable = false)
    private Imovel imovel;

    @Column(name = "climov_dtiniciorelacao", nullable = false)
    private LocalDate dtInicioRelacao;

    @Column(name = "climov_dtinfimrelacao")
    private LocalDate dtFimrelacao;


    @ManyToOne
    @JoinColumn(name = "cfrm_id")
    private ClienteFimRelacaoMotivo fimRelacaoMotivo;

    @ManyToOne
    @JoinColumn(name = "crtp_id", nullable = false)
    private ClienteRelacaoTipo clienteRelacaoTipo;

    @Column(name = "clie_icnomeconta", precision = 1, scale = 0)
    private Integer icNomeConta;

    @Column(name = "climov_ultima_atualizacao", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDate ultimaAtualizacao;
    

     public Integer getClimovId() {
        return climovId;
    }

    public void setClimovId(Integer climovId) {
        this.climovId = climovId;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    public LocalDate getDtInicioRelacao() {
        return dtInicioRelacao;
    }

    public void setDtInicioRelacao(LocalDate dtInicioRelacao) {
        this.dtInicioRelacao = dtInicioRelacao;
    }

    public LocalDate getDtFimRelacao() {
        return dtFimrelacao;
    }

    public void setDtFimRelacao(LocalDate dtFimRelacao) {
        this.dtFimrelacao = dtFimRelacao;
    }

    public ClienteFimRelacaoMotivo getFimRelacaoMotivo() {
        return fimRelacaoMotivo;
    }

 

    public void setFimRelacaoMotivo(ClienteFimRelacaoMotivo fimRelacaoMotivo) {
        this.fimRelacaoMotivo = fimRelacaoMotivo;
    }

    public ClienteRelacaoTipo getRelacaoTipo() {
        return clienteRelacaoTipo;
    }

    public void setRelacaoTipo(ClienteRelacaoTipo relacaoTipo) {
        this.clienteRelacaoTipo = relacaoTipo;
    }

    public Integer getIcNomeConta() {
        return icNomeConta;
    }

    public void setIcNomeConta(Integer icNomeConta) {
        this.icNomeConta = icNomeConta;
    }

    public LocalDate getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public void setUltimaAtualizacao(LocalDate ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }

}
