package com.trabalhorodolfo.trabalhorodolfo.repository;

import com.trabalhorodolfo.trabalhorodolfo.model.Carta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaRepository extends JpaRepository<Carta, Long> {
}