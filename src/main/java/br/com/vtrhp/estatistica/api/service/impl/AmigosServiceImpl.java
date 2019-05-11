package br.com.vtrhp.estatistica.api.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vtrhp.estatistica.api.entities.Amigos;
import br.com.vtrhp.estatistica.api.repository.AmigosRepository;
import br.com.vtrhp.estatistica.api.service.AmigosService;
@Service
public class AmigosServiceImpl implements AmigosService{
	@Autowired
	private AmigosRepository amigosRepository;

	@Override
	public Optional<Amigos> buscarPorId(Long id) {		
		return amigosRepository.findById(id);
	}

	@Override
	public Amigos persistir(Amigos amigos) {		
		return amigosRepository.save(amigos);
	}

}
