package br.com.vtrhp.estatistica.api.service;

import java.util.Optional;

import br.com.vtrhp.estatistica.api.entities.Profissao;

public interface ProfissaoService {
	
	Optional<Profissao> buscarPorId(Long id);
	
	Profissao persistir(Profissao profissao);

}
