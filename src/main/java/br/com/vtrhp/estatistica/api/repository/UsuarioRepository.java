package br.com.vtrhp.estatistica.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.vtrhp.estatistica.api.entities.Usuario;

@Transactional(readOnly = true)
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	@Transactional(readOnly = true)
	Optional<Usuario> findById(Long id);
}
