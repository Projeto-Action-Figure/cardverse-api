package com.trabalhorodolfo.trabalhorodolfo.service;

import com.trabalhorodolfo.trabalhorodolfo.model.Deck;
import com.trabalhorodolfo.trabalhorodolfo.model.Partida;
import com.trabalhorodolfo.trabalhorodolfo.model.Usuario;
import com.trabalhorodolfo.trabalhorodolfo.repository.DeckRepository;
import com.trabalhorodolfo.trabalhorodolfo.repository.PartidaRepository;
import com.trabalhorodolfo.trabalhorodolfo.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartidaService {

    private final PartidaRepository partidaRepository;
    private final UsuarioRepository usuarioRepository;
    private final DeckRepository deckRepository;

    public PartidaService(
            PartidaRepository partidaRepository,
            UsuarioRepository usuarioRepository,
            DeckRepository deckRepository
    ) {
        this.partidaRepository = partidaRepository;
        this.usuarioRepository = usuarioRepository;
        this.deckRepository = deckRepository;
    }

    public List<Partida> listarTodas() {
        return partidaRepository.findAll();
    }

    public Partida buscarPorId(Long id) {
        return partidaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Partida nao encontrada"));
    }

    public List<Partida> listarPorUsuario(Long usuarioId) {
        return partidaRepository.findByUsuarioId(usuarioId);
    }

    public Partida criar(Partida partida) {
        Long usuarioId = partida.getUsuario().getId();
        Long deckId = partida.getDeck().getId();

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario nao encontrado"));

        Deck deck = deckRepository.findById(deckId)
                .orElseThrow(() -> new RuntimeException("Deck nao encontrado"));

        partida.setUsuario(usuario);
        partida.setDeck(deck);

        return partidaRepository.save(partida);
    }

    public Partida atualizar(Long id, Partida novaPartida) {
        Partida partida = buscarPorId(id);

        partida.setResultado(novaPartida.getResultado());
        partida.setTurnos(novaPartida.getTurnos());

        if (novaPartida.getUsuario() != null && novaPartida.getUsuario().getId() != null) {
            Usuario usuario = usuarioRepository.findById(novaPartida.getUsuario().getId())
                    .orElseThrow(() -> new RuntimeException("Usuario nao encontrado"));

            partida.setUsuario(usuario);
        }

        if (novaPartida.getDeck() != null && novaPartida.getDeck().getId() != null) {
            Deck deck = deckRepository.findById(novaPartida.getDeck().getId())
                    .orElseThrow(() -> new RuntimeException("Deck nao encontrado"));

            partida.setDeck(deck);
        }

        return partidaRepository.save(partida);
    }

    public void deletar(Long id) {
        buscarPorId(id);
        partidaRepository.deleteById(id);
    }
}
