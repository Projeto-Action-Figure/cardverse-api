package com.trabalhorodolfo.trabalhorodolfo.repository;

import com.trabalhorodolfo.trabalhorodolfo.model.Deck;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeckRepository extends JpaRepository<Deck, Long> {
    List<Deck> findByUsuarioId(Long usuarioId);
}
