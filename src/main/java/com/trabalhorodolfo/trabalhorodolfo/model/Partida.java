package com.trabalhorodolfo.trabalhorodolfo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

@Entity
@Table(name = "partidas")
public class Partida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "deck_id")
    private Deck deck;

    @NotBlank
    private String resultado;

    private Integer turnos;

    @Column(name = "data_partida")
    private LocalDateTime dataPartida;

    public Partida() {
    }

    @PrePersist
    public void prePersist() {
        if (dataPartida == null) {
            dataPartida = LocalDateTime.now();
        }
    }

    public Long getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Deck getDeck() {
        return deck;
    }

    public String getResultado() {
        return resultado;
    }

    public Integer getTurnos() {
        return turnos;
    }

    public LocalDateTime getDataPartida() {
        return dataPartida;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public void setTurnos(Integer turnos) {
        this.turnos = turnos;
    }

    public void setDataPartida(LocalDateTime dataPartida) {
        this.dataPartida = dataPartida;
    }
}