package br.com.vtrhp.estatistica.api.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vtrhp.estatistica.api.entities.Visao;
import br.com.vtrhp.estatistica.api.repository.VisaoRepository;
import br.com.vtrhp.estatistica.api.service.VisaoService;

@Service
public class VisaoServiceImpl implements VisaoService {
	@Autowired
	private VisaoRepository visaoRepository;

	@Override
	public Optional<Visao> buscarPorId(Long id) {
		return visaoRepository.findById(id);
	}

	@Override
	public Visao persistir(Visao visao) {		
		return visaoRepository.save(visao);
	}

}
