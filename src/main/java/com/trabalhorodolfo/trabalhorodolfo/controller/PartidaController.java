package com.trabalhorodolfo.trabalhorodolfo.controller;

import com.trabalhorodolfo.trabalhorodolfo.model.Partida;
import com.trabalhorodolfo.trabalhorodolfo.service.PartidaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partidas")
@CrossOrigin(origins = "*")
public class PartidaController {

    private final PartidaService partidaService;

    public PartidaController(PartidaService partidaService) {
        this.partidaService = partidaService;
    }

    @GetMapping
    public List<Partida> listarTodas() {
        return partidaService.listarTodas();
    }

    @GetMapping("/{id}")
    public Partida buscarPorId(@PathVariable Long id) {
        return partidaService.buscarPorId(id);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Partida> listarPorUsuario(@PathVariable Long usuarioId) {
        return partidaService.listarPorUsuario(usuarioId);
    }

    @PostMapping
    public Partida criar(@RequestBody @Valid Partida partida) {
        return partidaService.criar(partida);
    }

    @PutMapping("/{id}")
    public Partida atualizar(@PathVariable Long id, @RequestBody @Valid Partida partida) {
        return partidaService.atualizar(id, partida);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        partidaService.deletar(id);
    }
}
