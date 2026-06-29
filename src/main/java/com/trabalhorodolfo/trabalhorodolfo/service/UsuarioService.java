package com.trabalhorodolfo.trabalhorodolfo.service;

import com.trabalhorodolfo.trabalhorodolfo.model.Usuario;
import com.trabalhorodolfo.trabalhorodolfo.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario nao encontrado"));
    }

    public Usuario criar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizar(Long id, Usuario novoUsuario) {
        Usuario usuario = buscarPorId(id);

        usuario.setNome(novoUsuario.getNome());
        usuario.setEmail(novoUsuario.getEmail());
        usuario.setSenha(novoUsuario.getSenha());
        usuario.setAdmin(novoUsuario.getAdmin());

        return usuarioRepository.save(usuario);
    }

    public void deletar(Long id) {
        buscarPorId(id);
        usuarioRepository.deleteById(id);
    }
}
