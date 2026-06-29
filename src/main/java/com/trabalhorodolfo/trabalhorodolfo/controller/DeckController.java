package com.trabalhorodolfo.trabalhorodolfo.controller;

import com.trabalhorodolfo.trabalhorodolfo.model.Deck;
import com.trabalhorodolfo.trabalhorodolfo.service.DeckService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/decks")
@CrossOrigin(origins = "*")
public class DeckController {

    private final DeckService deckService;

    public DeckController(DeckService deckService) {
        this.deckService = deckService;
    }

    @GetMapping
    public List<Deck> listarTodos() {
        return deckService.listarTodos();
    }

    @GetMapping("/{id}")
    public Deck buscarPorId(@PathVariable Long id) {
        return deckService.buscarPorId(id);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Deck> listarPorUsuario(@PathVariable Long usuarioId) {
        return deckService.listarPorUsuario(usuarioId);
    }

    @PostMapping
    public Deck criar(@RequestBody @Valid Deck deck) {
        return deckService.criar(deck);
    }

    @PutMapping("/{id}")
    public Deck atualizar(@PathVariable Long id, @RequestBody @Valid Deck deck) {
        return deckService.atualizar(id, deck);
    }

    @PutMapping("/{id}/ativar")
    public Deck ativarDeck(@PathVariable Long id) {
        return deckService.ativarDeck(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        deckService.deletar(id);
    }
}
