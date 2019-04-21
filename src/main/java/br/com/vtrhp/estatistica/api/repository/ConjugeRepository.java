package br.com.vtrhp.estatistica.api.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import br.com.vtrhp.estatistica.api.entities.Conjuge;

@Transactional(readOnly = true)
public interface ConjugeRepository extends JpaRepository<Conjuge, Long> {
	@Transactional(readOnly = true)
	Optional<Conjuge> findById(Long id);
	
	Conjuge findByCpf(String cpf);
	
	Conjuge findByEmail(String email);
	
	Conjuge findByCpfOrEmail(String cpf, String email);

}
