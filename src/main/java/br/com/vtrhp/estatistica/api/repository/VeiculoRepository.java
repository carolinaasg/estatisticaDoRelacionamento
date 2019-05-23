package br.com.vtrhp.estatistica.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.vtrhp.estatistica.api.entities.Veiculo;

@Transactional(readOnly = true)
public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{
	@Transactional(readOnly = true)
	Optional<Veiculo> findById(Long id);

}
