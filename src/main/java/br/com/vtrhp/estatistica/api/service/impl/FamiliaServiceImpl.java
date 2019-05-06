package br.com.vtrhp.estatistica.api.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vtrhp.estatistica.api.entities.Familia;
import br.com.vtrhp.estatistica.api.repository.FamiliaRepository;
import br.com.vtrhp.estatistica.api.service.FamiliaService;

@Service
public class FamiliaServiceImpl implements FamiliaService {

	@Autowired
	private FamiliaRepository familiaRepository;

	public Optional<Familia> buscarPorId(Long id) {
		return familiaRepository.findById(id);
	}

	@Override
	public Familia persistir(Familia familia) {
		// TODO Auto-generated method stub
		return familiaRepository.save(familia);
	}

}
