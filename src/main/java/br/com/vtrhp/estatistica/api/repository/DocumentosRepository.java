package br.com.vtrhp.estatistica.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.vtrhp.estatistica.api.entities.Documentos;

public interface DocumentosRepository extends JpaRepository<Documentos, Long>{
	@Transactional(readOnly = true)
	Optional<Documentos> findById(Long id);
}
