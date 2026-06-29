package com.trabalhorodolfo.trabalhorodolfo.repository;

import com.trabalhorodolfo.trabalhorodolfo.model.Partida;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PartidaRepository extends JpaRepository<Partida, Long> {
    List<Partida> findByUsuarioId(Long usuarioId);
}
