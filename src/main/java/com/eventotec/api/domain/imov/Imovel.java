package com.eventotec.api.domain.imov;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "houses")
public class Imovel {    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "imovel_id")
    private Long id;

    @Column(name = "rua", nullable = false, length = 100)
    private String rua;

    @Column(name = "numero_casa", nullable = false, length = 100)
    private String numeroCasa;

    @Column(name = "bloco", nullable = false, length = 100)
    private String bloco;

    @Column(name = "descricao", nullable = false, length = 200)
    private String descricao;

    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt;

    @Column(name = "andar", nullable = false, length = 50)
    private String andar;

    @Column(name = "ic_exclusao")
    private Long ic_exclusao;
    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(String numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public String getBloco() {
        return bloco;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public String getAndar() {
        return andar;
    }

    public void setAndar(String andar) {
        this.andar = andar;
    }

    public void setExclusao (Long ic_exclusao){
        this.ic_exclusao = ic_exclusao;
    }

    public Long getExclusao (){
        return ic_exclusao;
    }
}
