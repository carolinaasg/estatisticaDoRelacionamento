package br.com.vtrhp.estatistica.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.vtrhp.estatistica.api.entities.Visao;

@Transactional(readOnly = true)
public interface VisaoRepository extends JpaRepository<Visao, Long> {
	@Transactional(readOnly = true)
	Optional<Visao> findById(Long id);
}
