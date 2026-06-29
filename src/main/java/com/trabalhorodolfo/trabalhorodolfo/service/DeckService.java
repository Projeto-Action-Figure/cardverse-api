package com.trabalhorodolfo.trabalhorodolfo.service;

import com.trabalhorodolfo.trabalhorodolfo.model.Deck;
import com.trabalhorodolfo.trabalhorodolfo.model.Usuario;
import com.trabalhorodolfo.trabalhorodolfo.repository.DeckRepository;
import com.trabalhorodolfo.trabalhorodolfo.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeckService {

    private final DeckRepository deckRepository;
    private final UsuarioRepository usuarioRepository;

    public DeckService(DeckRepository deckRepository, UsuarioRepository usuarioRepository) {
        this.deckRepository = deckRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<Deck> listarTodos() {
        return deckRepository.findAll();
    }

    public Deck buscarPorId(Long id) {
        return deckRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Deck nao encontrado"));
    }

    public List<Deck> listarPorUsuario(Long usuarioId) {
        return deckRepository.findByUsuarioId(usuarioId);
    }

    public Deck criar(Deck deck) {
        Long usuarioId = deck.getUsuario().getId();

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario nao encontrado"));

        deck.setUsuario(usuario);

        return deckRepository.save(deck);
    }

    public Deck atualizar(Long id, Deck novoDeck) {
        Deck deck = buscarPorId(id);

        deck.setNome(novoDeck.getNome());
        deck.setAtivo(novoDeck.getAtivo());

        if (novoDeck.getUsuario() != null && novoDeck.getUsuario().getId() != null) {
            Usuario usuario = usuarioRepository.findById(novoDeck.getUsuario().getId())
                    .orElseThrow(() -> new RuntimeException("Usuario nao encontrado"));

            deck.setUsuario(usuario);
        }

        return deckRepository.save(deck);
    }

    public Deck ativarDeck(Long id) {
        Deck deckAtivo = buscarPorId(id);
        Long usuarioId = deckAtivo.getUsuario().getId();

        List<Deck> decksDoUsuario = deckRepository.findByUsuarioId(usuarioId);

        for (Deck deck : decksDoUsuario) {
            deck.setAtivo(0);
        }

        deckAtivo.setAtivo(1);

        deckRepository.saveAll(decksDoUsuario);

        return deckRepository.save(deckAtivo);
    }

    public void deletar(Long id) {
        buscarPorId(id);
        deckRepository.deleteById(id);
    }
}
