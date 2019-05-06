package br.com.vtrhp.estatistica.api.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vtrhp.estatistica.api.entities.Usuario;
import br.com.vtrhp.estatistica.api.repository.UsuarioRepository;
import br.com.vtrhp.estatistica.api.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Optional<Usuario> buscarPorId(Long id) {	
		return usuarioRepository.findById(id);
	}

	@Override
	public Usuario persistir(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

}
