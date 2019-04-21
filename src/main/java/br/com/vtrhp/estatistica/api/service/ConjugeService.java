package br.com.vtrhp.estatistica.api.service;

import java.util.Optional;

import br.com.vtrhp.estatistica.api.entities.Conjuge;

public interface ConjugeService {
	
	Optional<Conjuge> buscarPorId(Long id);
	
	Conjuge persistir(Conjuge conjuge);

}
