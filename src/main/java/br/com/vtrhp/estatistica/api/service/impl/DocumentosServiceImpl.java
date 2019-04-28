package br.com.vtrhp.estatistica.api.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vtrhp.estatistica.api.entities.Documentos;
import br.com.vtrhp.estatistica.api.repository.DocumentosRepository;
import br.com.vtrhp.estatistica.api.service.DocumentosService;

@Service
public class DocumentosServiceImpl implements DocumentosService{
	
	@Autowired
	private DocumentosRepository documentosRepository;

	@Override
	public  Optional<Documentos>  buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return documentosRepository.findById(id);
	}

	@Override
	public Documentos persistir(Documentos documentos) {
		// TODO Auto-generated method stub
		return this.documentosRepository.save(documentos);
	}

}
