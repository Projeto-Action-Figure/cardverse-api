package com.trabalhorodolfo.trabalhorodolfo.service;

import com.trabalhorodolfo.trabalhorodolfo.model.Carta;
import com.trabalhorodolfo.trabalhorodolfo.repository.CartaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartaService {

    private final CartaRepository cartaRepository;

    public CartaService(CartaRepository cartaRepository) {
        this.cartaRepository = cartaRepository;
    }

    public List<Carta> listarTodas() {
        return cartaRepository.findAll();
    }

    public Carta buscarPorId(Long id) {
        return cartaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carta não encontrada"));
    }

    public Carta criar(Carta carta) {
        return cartaRepository.save(carta);
    }

    public Carta atualizar(Long id, Carta novaCarta) {
        Carta carta = buscarPorId(id);

        carta.setNome(novaCarta.getNome());
        carta.setUniverso(novaCarta.getUniverso());
        carta.setTipo(novaCarta.getTipo());
        carta.setCustoElixir(novaCarta.getCustoElixir());
        carta.setVida(novaCarta.getVida());
        carta.setDano(novaCarta.getDano());
        carta.setDescricao(novaCarta.getDescricao());
        carta.setEfeito(novaCarta.getEfeito());
        carta.setImagem(novaCarta.getImagem());

        return cartaRepository.save(carta);
    }

    public void deletar(Long id) {
        buscarPorId(id);
        cartaRepository.deleteById(id);
    }
}
