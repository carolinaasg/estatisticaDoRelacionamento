package br.com.vtrhp.estatistica.api.service;

import java.util.Optional;

import br.com.vtrhp.estatistica.api.entities.Familia;

public interface FamiliaService {

	Optional<Familia> buscarPorId(Long id);

	Familia persistir(Familia familia);

}
