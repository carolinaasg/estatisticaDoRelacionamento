package br.com.vtrhp.estatistica.api.controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vtrhp.estatistica.api.dtos.AmigosDTO;
import br.com.vtrhp.estatistica.api.entities.Amigos;
import br.com.vtrhp.estatistica.api.enums.NacionalidadeEnum;
import br.com.vtrhp.estatistica.api.enums.OrientacaoSexualEnum;
import br.com.vtrhp.estatistica.api.enums.PaisesEnum;
import br.com.vtrhp.estatistica.api.enums.SexoEnum;
import br.com.vtrhp.estatistica.api.enums.SignosEnum;
import br.com.vtrhp.estatistica.api.response.Response;
import br.com.vtrhp.estatistica.api.service.AmigosService;
import br.com.vtrhp.estatistica.api.service.ConjugeService;
import br.com.vtrhp.estatistica.api.service.UsuarioService;

@RestController
@RequestMapping("/api/amigos")
@CrossOrigin("*")
public class AmigosController {
	
	private static final Logger log = LoggerFactory.getLogger(AmigosController.class);
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");


	@Autowired
	private ConjugeService conjugeService;
	@Autowired
	private AmigosService amigosService;
	@Autowired
	private UsuarioService usuarioService;
	
	
	
	@PostMapping("/adicionar/{tipo}/{id}")
	public ResponseEntity<Response<AmigosDTO>> adicionar(@Validated @RequestBody AmigosDTO amigosDTO,
			@PathVariable("tipo") String tipo, @PathVariable("id") Long id, BindingResult result){
		
		Response<AmigosDTO> response = new Response<AmigosDTO>();
		log.info("Response criado:{}", response.toString());		
		try {
			Amigos amigos = this.converterDtoParaAmigos(amigosDTO, result);
			
			log.info("Convertido para Amigo:{}", amigos.toString());
			
			if(result.hasErrors()) {
				log.error("Erro validando Amigo: {}", amigos.toString());				
				result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
				return ResponseEntity.badRequest().body(response);
			}
			
			if (tipo == null || "".equals(tipo)) {
				log.error("Tipo não pode ser vazio: {}", tipo);
				return ResponseEntity.badRequest().body(response);
			} else {
				if (tipo.equals("usuario")) {
					amigos.setUsuario(this.usuarioService.buscarPorId(id).get());					
				}
				if (tipo.equals("conjuge")) {
					amigos.setConjuge(this.conjugeService.buscarPorId(id).get());					
				}
			}
			
			amigos = amigosService.persistir(amigos);			
			
			response.setData(this.converterAmigosDTO(amigos));			
			
		}catch (Exception e) {
			log.error("Erro ao adicionar um Amigo.");
			e.printStackTrace();
			return ResponseEntity.badRequest().body(response);
		}
		
		return ResponseEntity.ok(response);		
	}

	private AmigosDTO converterAmigosDTO(Amigos amigos) {
		AmigosDTO amigoDTO = new AmigosDTO();
		
		amigoDTO.setIdAmigo(amigos.getIdAmigo());
		amigoDTO.setNome(amigos.getNome());
		amigoDTO.setAltura(amigos.getAltura());
		amigoDTO.setPeso(amigos.getPeso());
		amigoDTO.setCorOlhos(amigos.getCorOlhos());
		amigoDTO.setCorCabelo(amigos.getCorCabelo());
		amigoDTO.setTipoSanguineo(amigos.getTipoSanguineo());
		amigoDTO.setSexo(amigos.getSexo().toString());
		amigoDTO.setDataNascimento(String.valueOf(amigos.getDataNascimento()));
		amigoDTO.setHoraNascimento(String.valueOf(amigos.getHoraNascimento()));
		amigoDTO.setEstadoNascimento(amigos.getEstadoNascimento());
		amigoDTO.setCidadeNascimento(amigos.getCidadeNascimento());
		amigoDTO.setOrientacaoSexual(amigos.getOrientacaoSexual().toString());
		amigoDTO.setPaisOrigem(amigos.getPaisOrigem().toString());
		amigoDTO.setNacionalidade(amigos.getNacionalidade().toString());
		amigoDTO.setAdotivo(amigos.getAdotivo());
		amigoDTO.setSigno(amigos.getSigno().toString());
		amigoDTO.setDescendencia(amigos.getDescendencia());
		amigoDTO.setTamanhoPe(amigos.getTamanhoPe());
		
		
		return amigoDTO;
	}

	private Amigos converterDtoParaAmigos(AmigosDTO amigosDTO, BindingResult result) {
		Amigos amigos = new Amigos();		
				
		if(amigosDTO.getIdAmigo() != null) {
			Optional<Amigos> amig = this.amigosService.buscarPorId(amigosDTO.getIdAmigo());
			
			if(amig.isPresent()) {
				amigos = amig.get();
			}else {
				result.addError(new ObjectError("Amigos", "Amigo nao encontrado."));
			}
			
		}else {
			amigos = new Amigos();
			
			if (amigosDTO.getIdAmigo() != null)
				amigos.setIdAmigo(amigosDTO.getIdAmigo());

			amigos.setNome(amigosDTO.getNome());
			amigos.setAltura(amigosDTO.getAltura());
			amigos.setPeso(amigosDTO.getPeso());
			amigos.setCorOlhos(amigosDTO.getCorOlhos());
			amigos.setCorCabelo(amigosDTO.getCorCabelo());
			amigos.setTipoSanguineo(amigosDTO.getTipoSanguineo());

			if (EnumUtils.isValidEnum(SexoEnum.class, amigosDTO.getSexo())) {
				amigos.setSexo(SexoEnum.valueOf(amigosDTO.getSexo()));
			} else {
				result.addError(new ObjectError("Sexo", "Sexo inválido."));
			}
			amigos.setDataNascimento(LocalDate.parse(amigosDTO.getDataNascimento(), formatter));
			amigos.setHoraNascimento(
					LocalTime.parse(amigosDTO.getHoraNascimento(), DateTimeFormatter.ofPattern("HH:mm")));
			amigos.setEstadoNascimento(amigosDTO.getEstadoNascimento());
			amigos.setCidadeNascimento(amigosDTO.getCidadeNascimento());

			if (EnumUtils.isValidEnum(OrientacaoSexualEnum.class, amigosDTO.getOrientacaoSexual())) {
				amigos.setOrientacaoSexual(OrientacaoSexualEnum.valueOf(amigosDTO.getOrientacaoSexual()));
			} else {
				result.addError(new ObjectError("Orientacao Sexual", "Orientacao Sexual inválido."));
			}

			if (EnumUtils.isValidEnum(PaisesEnum.class, amigosDTO.getPaisOrigem())) {
				amigos.setPaisOrigem(PaisesEnum.valueOf(amigosDTO.getPaisOrigem()));
			} else {
				result.addError(new ObjectError("Pais de Origem", "Pais de Origem inválido."));
			}

			if (EnumUtils.isValidEnum(NacionalidadeEnum.class, amigosDTO.getNacionalidade())) {
				amigos.setNacionalidade(NacionalidadeEnum.valueOf(amigosDTO.getNacionalidade()));
			} else {
				result.addError(new ObjectError("Nacionalidade", "Nacionalidade inválida."));
			}
			amigos.setAdotivo(amigosDTO.getAdotivo());

			if (EnumUtils.isValidEnum(SignosEnum.class, amigosDTO.getSigno())) {
				amigos.setSigno(SignosEnum.valueOf(amigosDTO.getSigno()));
			} else {
				result.addError(new ObjectError("Signo", "Signo inválido."));
			}
			amigos.setDescendencia(amigosDTO.getDescendencia());
			amigos.setTamanhoPe(amigosDTO.getTamanhoPe());
		}
		
		return amigos;
	}
	
	

}
