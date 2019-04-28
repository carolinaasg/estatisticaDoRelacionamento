package br.com.vtrhp.estatistica.api.service;

import java.util.Optional;

import br.com.vtrhp.estatistica.api.entities.Documentos;

public interface DocumentosService {

	Optional<Documentos> buscarPorId(Long id);
	
	Documentos persistir(Documentos documentos);
}
