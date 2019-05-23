package br.com.vtrhp.estatistica.api.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vtrhp.estatistica.api.entities.Veiculo;
import br.com.vtrhp.estatistica.api.repository.VeiculoRepository;
import br.com.vtrhp.estatistica.api.service.VeiculoService;

@Service
public class VeiculoServiceImpl implements VeiculoService{
	@Autowired
	private VeiculoRepository veiculoRepository;

	@Override
	public Optional<Veiculo> buscarPorId(Long id) {		
		return veiculoRepository.findById(id);
	}

	@Override
	public Veiculo persistir(Veiculo veiculo) {		
		return veiculoRepository.save(veiculo);
	}

}
