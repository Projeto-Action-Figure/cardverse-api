package com.trabalhorodolfo.trabalhorodolfo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "deck_cartas")
public class DeckCarta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "deck_id")
    private Deck deck;

    @ManyToOne
    @JoinColumn(name = "carta_id")
    private Carta carta;

    private Integer quantidade;

    public DeckCarta() {
    }

    public Long getId() {
        return id;
    }

    public Deck getDeck() {
        return deck;
    }

    public Carta getCarta() {
        return carta;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public void setCarta(Carta carta) {
        this.carta = carta;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
