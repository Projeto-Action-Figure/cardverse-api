package com.trabalhorodolfo.trabalhorodolfo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "cartas")
public class Carta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String universo;

    @NotBlank
    private String tipo;

    @NotNull
    private Integer custoElixir;

    private Integer vida;
    private Integer dano;

    private String descricao;
    private String efeito;
    private String imagem;

    public Carta() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getUniverso() {
        return universo;
    }

    public String getTipo() {
        return tipo;
    }

    public Integer getCustoElixir() {
        return custoElixir;
    }

    public Integer getVida() {
        return vida;
    }

    public Integer getDano() {
        return dano;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getEfeito() {
        return efeito;
    }

    public String getImagem() {
        return imagem;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setUniverso(String universo) {
        this.universo = universo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setCustoElixir(Integer custoElixir) {
        this.custoElixir = custoElixir;
    }

    public void setVida(Integer vida) {
        this.vida = vida;
    }

    public void setDano(Integer dano) {
        this.dano = dano;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setEfeito(String efeito) {
        this.efeito = efeito;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
