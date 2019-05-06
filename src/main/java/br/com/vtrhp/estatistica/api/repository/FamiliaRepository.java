package br.com.vtrhp.estatistica.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.vtrhp.estatistica.api.entities.Familia;
@Transactional(readOnly = true)
public interface FamiliaRepository extends JpaRepository<Familia, Long> {
	@Transactional(readOnly = true)
	Optional<Familia> findById(Long id);

}
