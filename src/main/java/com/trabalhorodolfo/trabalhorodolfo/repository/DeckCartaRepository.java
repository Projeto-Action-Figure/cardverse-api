package com.trabalhorodolfo.trabalhorodolfo.repository;

import com.trabalhorodolfo.trabalhorodolfo.model.DeckCarta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeckCartaRepository extends JpaRepository<DeckCarta, Long> {
    List<DeckCarta> findByDeckId(Long deckId);
}
