package br.com.vtrhp.estatistica.api.service;

import java.util.Optional;

import br.com.vtrhp.estatistica.api.entities.Visao;

public interface VisaoService {
	
	Optional<Visao> buscarPorId(Long id);
	
	Visao persistir(Visao visao);

}
