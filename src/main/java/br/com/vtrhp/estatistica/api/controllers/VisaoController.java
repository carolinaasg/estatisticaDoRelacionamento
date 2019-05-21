package br.com.vtrhp.estatistica.api.controllers;

import java.util.Optional;

import org.apache.commons.lang3.EnumUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vtrhp.estatistica.api.dtos.VisaoDTO;
import br.com.vtrhp.estatistica.api.entities.Visao;
import br.com.vtrhp.estatistica.api.enums.ProblemasVisao;
import br.com.vtrhp.estatistica.api.response.Response;
import br.com.vtrhp.estatistica.api.service.AmigosService;
import br.com.vtrhp.estatistica.api.service.ConjugeService;
import br.com.vtrhp.estatistica.api.service.FamiliaService;
import br.com.vtrhp.estatistica.api.service.UsuarioService;
import br.com.vtrhp.estatistica.api.service.VisaoService;

@RestController
@RequestMapping("/api/visao")
@CrossOrigin("*")
public class VisaoController {
	
	private static final Logger log = LoggerFactory.getLogger(VisaoController.class);
	@Autowired
	private VisaoService visaoService;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private ConjugeService conjugeService;
	@Autowired
	private AmigosService amigosService;
	@Autowired
	private FamiliaService familiaService;
	
	
	@RequestMapping("/adicionar/{tipo}/{id}")
	public ResponseEntity<Response<VisaoDTO>> adicionar(@Validated @RequestBody VisaoDTO visaoDto, 
			@PathVariable("tipo") String tipo, @PathVariable("id") Long id, BindingResult result){
		
		Response<VisaoDTO> response = new Response<VisaoDTO>();
		log.info("Response criado:{}", response.toString());
		
		try {
			log.info("Convertendo DTO: {}", visaoDto.toString());
			Visao visao = this.converterDtoParaVisao(visaoDto, result);
			log.info("DTO convertido: {}", visao.toString());
			
			if(result.hasErrors()) {
				log.error("Erro validando visao: {}", visao.toString());
				result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage() ));
				return ResponseEntity.badRequest().body(response);
			}
			
			if ((tipo == null || "".equals(tipo)) && (id == null && "".equals(id))) {
				log.error("Tipo ou Id não foi informado.");
				return ResponseEntity.badRequest().body(response);
			} else {
				if (tipo.equals("usuario")) {
					log.info("Buscando usuario");
					if (visaoService.buscarPorId(id).isPresent()) {
						visao.setUsuario(usuarioService.buscarPorId(id).get());						
					} else {
						log.error("Id do Usuario não encontrado", id.toString());
						return ResponseEntity.badRequest().body(response);
					}
				} else if (tipo.equals("conjuge")) {
					log.info("Buscando conjuge");
					if (conjugeService.buscarPorId(id).isPresent()) {
						visao.setConjuge(conjugeService.buscarPorId(id).get());						
					} else {
						log.error("Id do Conjuge não encontrado", id.toString());
						return ResponseEntity.badRequest().body(response);
					}
				} else if (tipo.equals("familia")) {
					log.info("Buscando familia");
					if (familiaService.buscarPorId(id).isPresent()) {
						visao.setFamilia(familiaService.buscarPorId(id).get());						
					} else {
						log.error("Id do Familia não encontrado", id.toString());
						return ResponseEntity.badRequest().body(response);
					}
				} else {
					log.info("Buscando amigos");
					if (amigosService.buscarPorId(id).isPresent()) {
						visao.setAmigos(amigosService.buscarPorId(id).get());						
					} else {
						log.error("Id do Amigos não encontrado", id.toString());
						return ResponseEntity.badRequest().body(response);
					}
				}
			}
			
			visao = this.visaoService.persistir(visao);
			
			response.setData(this.converterVisaoDTO(visao));
			
			
		}catch (Exception e) {
			log.error("Erro ao adicionar problema de Visao.");
			e.printStackTrace();
		}		
		
		return ResponseEntity.ok(response);
	}
	
	private Visao converterDtoParaVisao(VisaoDTO visaoDTO, BindingResult result) {
		Visao visao = new Visao();
		
		if(visaoDTO.getIdVisao() != null) {
			Optional<Visao> vis = this.visaoService.buscarPorId(visaoDTO.getIdVisao());
			if(vis.isPresent()) {
				log.info("ID encontrado: {}", visaoDTO.getIdVisao());
				visao =vis.get();
			}else {
				result.addError( new ObjectError("Visao", "Problema de visão não encontrado.")); 
			}
		}else {
			visao = new Visao();
			
			visao.setGrauEsquerdo(visaoDTO.getGrauEsquerdo());
			visao.setGrauDireito(visaoDTO.getGrauDireito());
			if(EnumUtils.isValidEnum(ProblemasVisao.class, visaoDTO.getTipoEsquerdo())) {
				visao.setTipoEsquerdo(ProblemasVisao.valueOf(visaoDTO.getTipoEsquerdo()));
			}else {
				result.addError(new ObjectError("Problemas Visao", "Problema de Visao inválido."));
			}
			
			if(EnumUtils.isValidEnum(ProblemasVisao.class, visaoDTO.getTipoDireito())) {
				visao.setTipoDireito(ProblemasVisao.valueOf(visaoDTO.getTipoDireito()));
			}else {
				result.addError(new ObjectError("Problemas Visao", "Problema de Visao inválido"));
			}
			visao.setUsaOculos(visaoDTO.getUsaOculos());
			visao.setFezCirurgia(visaoDTO.getFezCirurgia());
			visao.setUsaLente(visaoDTO.getUsaLente());
			
		}
		return visao;
		
	}
	
	
	private VisaoDTO converterVisaoDTO(Visao visao) {
		log.info("Metodo converterVisaoDTO()");
		
		VisaoDTO visaoDTO = new VisaoDTO();
		
		visaoDTO.setIdVisao(visao.getIdVisao());
		visaoDTO.setGrauEsquerdo(visao.getGrauEsquerdo());
		visaoDTO.setGrauDireito(visao.getGrauDireito());		
		visaoDTO.setTipoEsquerdo(String.valueOf(visao.getTipoEsquerdo()));
		visaoDTO.setTipoDireito(String.valueOf(visao.getTipoDireito()));
		visaoDTO.setUsaOculos(visao.getUsaOculos());
		visaoDTO.setFezCirurgia(visao.getFezCirurgia());
		visaoDTO.setUsaLente(visao.getUsaLente());
		
		log.info("Retornando DTO:", visaoDTO.toString());
		return visaoDTO;
	}

}
