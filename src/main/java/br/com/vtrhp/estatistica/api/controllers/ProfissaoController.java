package br.com.vtrhp.estatistica.api.controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vtrhp.estatistica.api.dtos.ProfissaoDTO;
import br.com.vtrhp.estatistica.api.entities.Profissao;
import br.com.vtrhp.estatistica.api.response.Response;
import br.com.vtrhp.estatistica.api.service.AmigosService;
import br.com.vtrhp.estatistica.api.service.ConjugeService;
import br.com.vtrhp.estatistica.api.service.FamiliaService;
import br.com.vtrhp.estatistica.api.service.ProfissaoService;
import br.com.vtrhp.estatistica.api.service.UsuarioService;

@RestController
@RequestMapping("/api/profissao")
@CrossOrigin("*")
public class ProfissaoController {

	private static final Logger log = LoggerFactory.getLogger(ProfissaoController.class);

	@Autowired
	private ProfissaoService profissaoService;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private FamiliaService familiaService;
	@Autowired
	private ConjugeService conjugeService;
	@Autowired
	private AmigosService amigosService;

	@PostMapping("/adicionar/{tipo}/{id}")
	public ResponseEntity<Response<ProfissaoDTO>> adicionar(@Validated @RequestBody ProfissaoDTO profissaoDTO,
			@PathVariable("tipo") String tipo, @PathVariable("id") Long id, BindingResult result)
			throws ParseException {
		log.info("Adicionando Profissao {}", profissaoDTO.toString());
		Response<ProfissaoDTO> response = new Response<ProfissaoDTO>();
		try {

			log.info("Response criado", response.toString());

			Profissao profissao = this.converterDtoParaProfissao(profissaoDTO, result);

			log.info("Convertido para Profissao {}", profissao.toString());

			if (result.hasErrors()) {
				log.error("Erro validando Profissao: {} ", result.getAllErrors());
				result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
				return ResponseEntity.badRequest().body(response);
			}

			if ((tipo == null || "".equals(tipo)) && (id == null && "".equals(id))) {
				log.info("Tipo ou Id não foi informado.");
				return ResponseEntity.badRequest().body(response);
			} else {
				if (tipo.equals("usuario")) {
					log.info("Buscando usuario");
					if (usuarioService.buscarPorId(id).isPresent()) {
						profissao.setUsuario(usuarioService.buscarPorId(id).get());						
					} else {
						log.info("Id do Usuario não encontrado", id.toString());
						return ResponseEntity.badRequest().body(response);
					}
				} else if (tipo.equals("conjuge")) {
					log.info("Buscando conjuge");
					if (conjugeService.buscarPorId(id).isPresent()) {
						profissao.setConjuge(conjugeService.buscarPorId(id).get());
						profissao.getConjuge().setIdConjuge(id);
					} else {
						return ResponseEntity.badRequest().body(response);
					}
				} else if (tipo.equals("familia")) {
					log.info("Buscando familia");
					if (familiaService.buscarPorId(id).isPresent()) {
						profissao.setFamilia(familiaService.buscarPorId(id).get());
						profissao.getFamilia().setIdFamilia(id);
					} else {
						return ResponseEntity.badRequest().body(response);
					}
				} else {
					log.info("Buscando amigos");
					if (amigosService.buscarPorId(id).isPresent()) {
						profissao.setAmigos(amigosService.buscarPorId(id).get());
						profissao.getAmigos().setIdAmigo(id);
					} else {
						return ResponseEntity.badRequest().body(response);
					}
				}
			}

			log.info("Adicionando Profissao: {}", profissao.toString());
			profissao = this.profissaoService.persistir(profissao);

			response.setData(this.converterProfissaoDTO(profissao));
		} catch (Exception e) {
			log.error("Erro ao adicionar Profissao.");
			e.printStackTrace();
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}

	private ProfissaoDTO converterProfissaoDTO(Profissao profissao) {
		log.info("Convertendo Profissao para ProfissaoDTO {}", profissao.toString());
		ProfissaoDTO profissaoDTO = new ProfissaoDTO();

		profissaoDTO.setIdProfissao(profissao.getIdProfissao());
		profissaoDTO.setNomeEmpresa(profissao.getNomeEmpresa());
		profissaoDTO.setProfissao(profissao.getProfissao());
		profissaoDTO.setCargo(profissao.getCargo());
		profissaoDTO.setDescricao(profissao.getDescricao());
		profissaoDTO.setSalarioBruto(profissao.getSalarioBruto());
		profissaoDTO.setSalarioLiquido(profissao.getSalarioLiquido());
		profissaoDTO.setQtdSubordinados(profissao.getQtdSubordinados());
		log.info("Profissao convertida para ProfissaoDTO {}", profissaoDTO.toString());

		return profissaoDTO;
	}

	private Profissao converterDtoParaProfissao(ProfissaoDTO profissaoDTO, BindingResult result) {
		Profissao profissao = new Profissao();		

		if (profissaoDTO.getIdProfissao() != null) {
			Optional<Profissao> prof = this.profissaoService.buscarPorId(profissaoDTO.getIdProfissao());

			if (prof.isPresent()) {
				profissao = prof.get();
			} else {
				result.addError(new ObjectError("profissao", "Profissao não encontrada"));
			}
		} else {
			profissao = new Profissao();

			profissao.setNomeEmpresa(profissaoDTO.getNomeEmpresa());
			profissao.setProfissao(profissaoDTO.getProfissao());
			profissao.setCargo(profissaoDTO.getCargo());
			profissao.setDescricao(profissaoDTO.getDescricao());
			profissao.setSalarioBruto(profissaoDTO.getSalarioBruto());
			profissao.setSalarioLiquido(profissaoDTO.getSalarioLiquido());
			profissao.setQtdSubordinados(profissaoDTO.getQtdSubordinados());
		}

		return profissao;
	}

}
