package br.com.vtrhp.estatistica.api.controllers;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.commons.lang3.EnumUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vtrhp.estatistica.api.dtos.ConjugeDTO;
import br.com.vtrhp.estatistica.api.entities.Conjuge;
import br.com.vtrhp.estatistica.api.entities.Documentos;
import br.com.vtrhp.estatistica.api.enums.NacionalidadeEnum;
import br.com.vtrhp.estatistica.api.enums.OrientacaoSexualEnum;
import br.com.vtrhp.estatistica.api.enums.PaisesEnum;
import br.com.vtrhp.estatistica.api.enums.SexoEnum;
import br.com.vtrhp.estatistica.api.enums.SignosEnum;
import br.com.vtrhp.estatistica.api.response.Response;
import br.com.vtrhp.estatistica.api.service.ConjugeService;
import br.com.vtrhp.estatistica.api.service.DocumentosService;

@RestController
@RequestMapping("/api/conjuge")
@CrossOrigin(origins = "*")
public class ConjugeController {

	private static final Logger log = LoggerFactory.getLogger(ConjugeController.class);
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	@Autowired
	private ConjugeService conjugeService;
	@Autowired
	private DocumentosService documentosService;

	@PostMapping(path = "/adicionar", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<ConjugeDTO>> adicionar(@Valid @RequestBody ConjugeDTO conjugeDto,
			BindingResult result) throws ParseException {

		log.info("Adicionando conjuge: {}", conjugeDto.toString());

		Response<ConjugeDTO> response = new Response<ConjugeDTO>();

		log.info("Response foi criado: {}", response.toString());

		// validarConjuge(conjugeDto, result);

		Conjuge conjuge = this.converterDtoParaConjuge(conjugeDto, result);	

		log.info("Convertido para Conjuge: {}", conjuge.toString());

		if (result.hasErrors()) {
			log.error("Erro validando conjuge: {}", result.getAllErrors());
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		conjuge = this.conjugeService.persistir(conjuge);
		conjugeDto.setIdConjuge(conjuge.getIdConjuge());
		
		if(conjugeDto.getDocumentos()!=null && !"".equals(conjugeDto.getDocumentos())) {
			log.info("Convertendo para Documentos: {}", conjugeDto.getDocumentos().toString());
			Documentos documentos = this.converterDtoParaDocumentos(conjugeDto, result);
			documentos = this.documentosService.persistir(documentos);
		}		
		
		response.setData(this.converterConjugeDto(conjuge));
		return ResponseEntity.ok(response);
	}

	@GetMapping(value = "/listar/{id}")
	public ResponseEntity<Response<ConjugeDTO>> listarPorId(@PathVariable("id") Long id) {
		log.info("Buscando lançamento por ID: {}", id);
		Response<ConjugeDTO> response = new Response<ConjugeDTO>();
		Optional<Conjuge> conjuge = this.conjugeService.buscarPorId(id);

		if (!conjuge.isPresent()) {
			log.info("Lançamento não encontrado para o ID: {}", id);
			response.getErrors().add("Lançamento não encontrado para o id " + id);
			return ResponseEntity.badRequest().body(response);
		}

		response.setData(this.converterConjugeDto(conjuge.get()));
		return ResponseEntity.ok(response);
	}
	
	
	@PutMapping(value = "/atualizar/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<ConjugeDTO>> atualizar(@PathVariable("id") Long id,
			@Valid @RequestBody ConjugeDTO conjugeDTO, BindingResult result) throws ParseException {
		log.info("Atualizando conjuge: {}", conjugeDTO.toString());

		Response<ConjugeDTO> response = new Response<ConjugeDTO>();		
		conjugeDTO.setIdConjuge(id);
		validarConjuge(conjugeDTO, result);
		Conjuge conjuge = this.converterDtoParaConjuge(conjugeDTO, result);

		if (result.hasErrors()) {
			log.error("Erro validando conjuge: {}", result.getAllErrors());
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		conjuge = this.conjugeService.persistir(conjuge);
		response.setData(this.converterConjugeDto(conjuge));
		return ResponseEntity.ok(response);
	}

	

	private Conjuge converterDtoParaConjuge(ConjugeDTO conjugeDTO, BindingResult result) throws ParseException {

		Conjuge conjuge = new Conjuge();

		if (conjugeDTO.getIdConjuge() != null) {
			Optional<Conjuge> lanc = this.conjugeService
					.buscarPorId(conjugeDTO.getIdConjuge());
			if (lanc.isPresent()) {
				conjuge = lanc.get();
			} else {
				result.addError(new ObjectError("conjuge", "Conjuge não encontrado."));
			}
		} else {
			conjuge = new Conjuge();
		}
		if (conjugeDTO.getIdConjuge() != null && !"".equals(conjugeDTO.getIdConjuge()))
			conjuge.setIdConjuge(conjugeDTO.getIdConjuge());

		conjuge.setNome(conjugeDTO.getNome());
		conjuge.setAltura(conjugeDTO.getAltura());
		conjuge.setPeso(conjugeDTO.getPeso());
		conjuge.setCorOlhos(conjugeDTO.getCorOlhos());
		conjuge.setCorCabelo(conjugeDTO.getCorCabelo());
		conjuge.setTipoSanguineo(conjugeDTO.getTipoSanguineo());

		if (EnumUtils.isValidEnum(SexoEnum.class, conjugeDTO.getSexo())) {
			conjuge.setSexo(SexoEnum.valueOf(conjugeDTO.getSexo()));
		} else {
			result.addError(new ObjectError("Sexo", "Sexo inválido."));
		}
		conjuge.setDataNascimento(LocalDate.parse(conjugeDTO.getDataNascimento(), formatter));
		conjuge.setHoraNascimento(
				LocalTime.parse(conjugeDTO.getHoraNascimento(), DateTimeFormatter.ofPattern("HH:mm")));
		conjuge.setEstadoNascimento(conjugeDTO.getEstadoNascimento());
		conjuge.setCidadeNascimento(conjugeDTO.getCidadeNascimento());

		if (EnumUtils.isValidEnum(OrientacaoSexualEnum.class, conjugeDTO.getOrientacaoSexual())) {
			conjuge.setOrientacaoSexual(OrientacaoSexualEnum.valueOf(conjugeDTO.getOrientacaoSexual()));
		} else {
			result.addError(new ObjectError("Orientacao Sexual", "Orientacao Sexual inválido."));
		}

		if (EnumUtils.isValidEnum(PaisesEnum.class, conjugeDTO.getPaisDeOrigem())) {
			conjuge.setPaisOrigem(PaisesEnum.valueOf(conjugeDTO.getPaisDeOrigem()));
		} else {
			result.addError(new ObjectError("Pais de Origem", "Pais de Origem inválido."));
		}

		if (EnumUtils.isValidEnum(NacionalidadeEnum.class, conjugeDTO.getNacionalidade())) {
			conjuge.setNacionalidade(NacionalidadeEnum.valueOf(conjugeDTO.getNacionalidade()));
		} else {
			result.addError(new ObjectError("Nacionalidade", "Nacionalidade inválida."));
		}
		conjuge.setAdotivo(conjugeDTO.getAdotivo());

		if (EnumUtils.isValidEnum(SignosEnum.class, conjugeDTO.getSigno())) {
			conjuge.setSigno(SignosEnum.valueOf(conjugeDTO.getSigno()));
		} else {
			result.addError(new ObjectError("Signo", "Signo inválido."));
		}
		conjuge.setDescendencia(conjugeDTO.getDescendencia());
		conjuge.setTamanhoPe(conjugeDTO.getTamanhoPe());
		return conjuge;
	}

	private ConjugeDTO converterConjugeDto(Conjuge conjuge) {
		ConjugeDTO conjugeDTO = new ConjugeDTO();

		conjugeDTO.setIdConjuge(conjuge.getIdConjuge());
		conjugeDTO.setNome(conjuge.getNome());
		conjugeDTO.setAltura(conjuge.getAltura());
		conjugeDTO.setPeso(conjuge.getPeso());
		conjugeDTO.setCorOlhos(conjuge.getCorOlhos());
		conjugeDTO.setCorCabelo(conjuge.getCorCabelo());
		conjugeDTO.setTipoSanguineo(conjuge.getTipoSanguineo());
		conjugeDTO.setSexo(conjuge.getSexo().toString());
		conjugeDTO.setDataNascimento(String.valueOf(conjuge.getDataNascimento()));
		conjugeDTO.setHoraNascimento(String.valueOf(conjuge.getHoraNascimento()));
		conjugeDTO.setEstadoNascimento(conjuge.getEstadoNascimento());
		conjugeDTO.setCidadeNascimento(conjuge.getCidadeNascimento());
		conjugeDTO.setOrientacaoSexual(conjuge.getOrientacaoSexual().toString());
		conjugeDTO.setPaisDeOrigem(conjuge.getPaisOrigem().toString());
		conjugeDTO.setNacionalidade(conjuge.getNacionalidade().toString());
		conjugeDTO.setAdotivo(conjuge.getAdotivo());
		conjugeDTO.setSigno(conjuge.getSigno().toString());
		conjugeDTO.setDescendencia(conjuge.getDescendencia());
		conjugeDTO.setTamanhoPe(conjuge.getTamanhoPe());

		return conjugeDTO;
	}

	private void validarConjuge(ConjugeDTO conjugeDTO, BindingResult result) {
		if (conjugeDTO.getIdConjuge() == null) {
			result.addError(new ObjectError("conjuge", "Conjuge não informado."));
			return;
		}

		log.info("Validando conjuge id {}: ", conjugeDTO.getIdConjuge());
		Optional<Conjuge> conjuge = this.conjugeService.buscarPorId(Long.valueOf(conjugeDTO.getIdConjuge().toString()));
		if (!conjuge.isPresent()) {
			result.addError(new ObjectError("conjuge", "Conjuge não encontrado. ID inexistente."));
		}
	}

	private Documentos converterDtoParaDocumentos(ConjugeDTO conjugeDTO, BindingResult result) throws ParseException {
		Documentos documentos = new Documentos();
		
		if(conjugeDTO.getDocumentos() != null && !"".equals(conjugeDTO.getDocumentos())) {	
			documentos.setConjuge(converterDtoParaConjuge(conjugeDTO, result));			
			documentos.setRg(conjugeDTO.getDocumentos().getRg());
			documentos.setCpf(conjugeDTO.getDocumentos().getCpf());
			documentos.setHabilitacao(conjugeDTO.getDocumentos().getHabilitacao());			
		}
		return documentos;

	}

}
