package com.trabalhorodolfo.trabalhorodolfo.service;

import com.trabalhorodolfo.trabalhorodolfo.model.Carta;
import com.trabalhorodolfo.trabalhorodolfo.model.Deck;
import com.trabalhorodolfo.trabalhorodolfo.model.DeckCarta;
import com.trabalhorodolfo.trabalhorodolfo.repository.CartaRepository;
import com.trabalhorodolfo.trabalhorodolfo.repository.DeckCartaRepository;
import com.trabalhorodolfo.trabalhorodolfo.repository.DeckRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeckCartaService {

    private final DeckCartaRepository deckCartaRepository;
    private final DeckRepository deckRepository;
    private final CartaRepository cartaRepository;

    public DeckCartaService(
            DeckCartaRepository deckCartaRepository,
            DeckRepository deckRepository,
            CartaRepository cartaRepository
    ) {
        this.deckCartaRepository = deckCartaRepository;
        this.deckRepository = deckRepository;
        this.cartaRepository = cartaRepository;
    }

    public List<DeckCarta> listarTodas() {
        return deckCartaRepository.findAll();
    }

    public DeckCarta buscarPorId(Long id) {
        return deckCartaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carta do deck nao encontrada"));
    }

    public List<DeckCarta> listarPorDeck(Long deckId) {
        return deckCartaRepository.findByDeckId(deckId);
    }

    public DeckCarta criar(DeckCarta deckCarta) {
        Long deckId = deckCarta.getDeck().getId();
        Long cartaId = deckCarta.getCarta().getId();

        Deck deck = deckRepository.findById(deckId)
                .orElseThrow(() -> new RuntimeException("Deck nao encontrado"));

        Carta carta = cartaRepository.findById(cartaId)
                .orElseThrow(() -> new RuntimeException("Carta nao encontrada"));

        deckCarta.setDeck(deck);
        deckCarta.setCarta(carta);

        if (deckCarta.getQuantidade() == null || deckCarta.getQuantidade() <= 0) {
            deckCarta.setQuantidade(1);
        }

        return deckCartaRepository.save(deckCarta);
    }

    public DeckCarta atualizar(Long id, DeckCarta novoDeckCarta) {
        DeckCarta deckCarta = buscarPorId(id);

        if (novoDeckCarta.getDeck() != null && novoDeckCarta.getDeck().getId() != null) {
            Deck deck = deckRepository.findById(novoDeckCarta.getDeck().getId())
                    .orElseThrow(() -> new RuntimeException("Deck nao encontrado"));

            deckCarta.setDeck(deck);
        }

        if (novoDeckCarta.getCarta() != null && novoDeckCarta.getCarta().getId() != null) {
            Carta carta = cartaRepository.findById(novoDeckCarta.getCarta().getId())
                    .orElseThrow(() -> new RuntimeException("Carta nao encontrada"));

            deckCarta.setCarta(carta);
        }

        deckCarta.setQuantidade(novoDeckCarta.getQuantidade());

        return deckCartaRepository.save(deckCarta);
    }

    public void deletar(Long id) {
        buscarPorId(id);
        deckCartaRepository.deleteById(id);
    }
}
