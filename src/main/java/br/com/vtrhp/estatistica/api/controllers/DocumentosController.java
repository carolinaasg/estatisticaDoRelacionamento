package br.com.vtrhp.estatistica.api.controllers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vtrhp.estatistica.api.dtos.ConjugeDTO;
import br.com.vtrhp.estatistica.api.entities.Documentos;
import br.com.vtrhp.estatistica.api.service.DocumentosService;

@RestController
@RequestMapping("/api/documentos")
@CrossOrigin(origins = "*")
public class DocumentosController {
	
	@Autowired
	private DocumentosService documentosService;
	
	


}
