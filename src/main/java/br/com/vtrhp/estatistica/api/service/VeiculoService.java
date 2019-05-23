package br.com.vtrhp.estatistica.api.service;

import java.util.Optional;

import br.com.vtrhp.estatistica.api.entities.Veiculo;

public interface VeiculoService {
	
	Optional<Veiculo> buscarPorId(Long id);
	
	Veiculo persistir(Veiculo veiculo);

}
