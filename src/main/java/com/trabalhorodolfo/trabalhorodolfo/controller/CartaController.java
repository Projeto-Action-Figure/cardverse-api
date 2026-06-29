package com.trabalhorodolfo.trabalhorodolfo.controller;

import com.trabalhorodolfo.trabalhorodolfo.model.Carta;
import com.trabalhorodolfo.trabalhorodolfo.service.CartaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartas")
@CrossOrigin(origins = "*")
public class CartaController {

    private final CartaService cartaService;

    public CartaController(CartaService cartaService) {
        this.cartaService = cartaService;
    }

    @GetMapping
    public List<Carta> listarTodas() {
        return cartaService.listarTodas();
    }

    @GetMapping("/{id}")
    public Carta buscarPorId(@PathVariable Long id) {
        return cartaService.buscarPorId(id);
    }

    @PostMapping
    public Carta criar(@RequestBody @Valid Carta carta) {
        return cartaService.criar(carta);
    }

    @PutMapping("/{id}")
    public Carta atualizar(@PathVariable Long id, @RequestBody @Valid Carta carta) {
        return cartaService.atualizar(id, carta);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        cartaService.deletar(id);
    }
}
