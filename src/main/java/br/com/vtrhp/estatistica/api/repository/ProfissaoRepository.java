package br.com.vtrhp.estatistica.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.vtrhp.estatistica.api.entities.Profissao;

@Transactional(readOnly = true)
public interface ProfissaoRepository extends JpaRepository<Profissao, Long> {
	@Transactional(readOnly = true)
	Optional<Profissao> findById(Long id);

}
