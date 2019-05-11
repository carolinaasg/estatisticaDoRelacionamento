package br.com.vtrhp.estatistica.api.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vtrhp.estatistica.api.entities.Profissao;
import br.com.vtrhp.estatistica.api.repository.ProfissaoRepository;
import br.com.vtrhp.estatistica.api.service.ProfissaoService;
@Service
public class ProfissaoServiceImpl implements ProfissaoService{
	@Autowired
	private ProfissaoRepository profissaoRepository;

	@Override
	public Optional<Profissao> buscarPorId(Long id) {		
		return profissaoRepository.findById(id);
	}

	@Override
	public Profissao persistir(Profissao profissao) {		
		return profissaoRepository.save(profissao);
	}

}
