package br.com.vtrhp.estatistica.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.vtrhp.estatistica.api.entities.Amigos;

@Transactional(readOnly = true)
public interface AmigosRepository extends JpaRepository<Amigos, Long>{
	@Transactional(readOnly = true)
	Optional<Amigos> findById(long id);
}
