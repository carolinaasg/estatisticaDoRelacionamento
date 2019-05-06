package br.com.vtrhp.estatistica.api.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vtrhp.estatistica.api.entities.Conjuge;
import br.com.vtrhp.estatistica.api.repository.ConjugeRepository;
import br.com.vtrhp.estatistica.api.service.ConjugeService;

@Service
public class ConjugeServiceImpl implements ConjugeService {
	@Autowired
	private ConjugeRepository conjugeRepository;

	@Override
	public Optional<Conjuge> buscarPorId(Long id) {
		return conjugeRepository.findById(id);
	}

	@Override
	public Conjuge persistir(Conjuge conjuge) {
		return this.conjugeRepository.save(conjuge);
	}

}
