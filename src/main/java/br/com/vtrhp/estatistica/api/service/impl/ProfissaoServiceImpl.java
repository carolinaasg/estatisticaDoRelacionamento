package br.com.vtrhp.estatistica.api.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.vtrhp.estatistica.api.entities.Profissao;
import br.com.vtrhp.estatistica.api.repository.ProfissaoRepository;
import br.com.vtrhp.estatistica.api.service.ProfissaoService;
@Service
public class ProfissaoServiceImpl implements ProfissaoService{
	
	private ProfissaoRepository profissaoRepository;

	@Override
	public Optional<Profissao> buscarPorId(Long id) {		
		return profissaoRepository.findById(id);
	}

	@Override
	public Profissao persistir(Profissao profissao) {
		// TODO Auto-generated method stub
		return profissaoRepository.save(profissao);
	}

}
