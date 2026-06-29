package com.trabalhorodolfo.trabalhorodolfo.controller;

import com.trabalhorodolfo.trabalhorodolfo.model.DeckCarta;
import com.trabalhorodolfo.trabalhorodolfo.service.DeckCartaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deck-cartas")
@CrossOrigin(origins = "*")
public class DeckCartaController {

    private final DeckCartaService deckCartaService;

    public DeckCartaController(DeckCartaService deckCartaService) {
        this.deckCartaService = deckCartaService;
    }

    @GetMapping
    public List<DeckCarta> listarTodas() {
        return deckCartaService.listarTodas();
    }

    @GetMapping("/{id}")
    public DeckCarta buscarPorId(@PathVariable Long id) {
        return deckCartaService.buscarPorId(id);
    }

    @GetMapping("/deck/{deckId}")
    public List<DeckCarta> listarPorDeck(@PathVariable Long deckId) {
        return deckCartaService.listarPorDeck(deckId);
    }

    @PostMapping
    public DeckCarta criar(@RequestBody DeckCarta deckCarta) {
        return deckCartaService.criar(deckCarta);
    }

    @PutMapping("/{id}")
    public DeckCarta atualizar(@PathVariable Long id, @RequestBody DeckCarta deckCarta) {
        return deckCartaService.atualizar(id, deckCarta);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        deckCartaService.deletar(id);
    }
}
