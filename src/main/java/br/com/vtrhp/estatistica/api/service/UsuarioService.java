package br.com.vtrhp.estatistica.api.service;

import java.util.List;
import java.util.Optional;

import br.com.vtrhp.estatistica.api.entities.Usuario;

public interface UsuarioService {

	Optional<Usuario> buscarPorId(Long id);

	Usuario persistir(Usuario usuario);
	
	List<Usuario> buscarTodos();

}
