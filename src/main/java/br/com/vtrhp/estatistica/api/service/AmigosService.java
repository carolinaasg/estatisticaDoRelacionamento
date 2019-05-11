package br.com.vtrhp.estatistica.api.service;

import java.util.Optional;

import br.com.vtrhp.estatistica.api.entities.Amigos;

public interface AmigosService {
	
	Optional<Amigos> buscarPorId(Long id);
	
	Amigos persistir(Amigos amigos);

}
