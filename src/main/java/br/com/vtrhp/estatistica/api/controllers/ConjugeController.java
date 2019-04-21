package br.com.vtrhp.estatistica.api.controllers;

import java.text.ParseException;
import java.util.Optional;

import javax.validation.Valid;
import javax.xml.ws.Response;

import org.apache.commons.lang3.EnumUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vtrhp.estatistica.api.dtos.ConjugeDTO;
import br.com.vtrhp.estatistica.api.entities.Conjuge;
import br.com.vtrhp.estatistica.api.enums.NacionalidadeEnum;
import br.com.vtrhp.estatistica.api.enums.OrientacaoSexualEnum;
import br.com.vtrhp.estatistica.api.enums.PaisesEnum;
import br.com.vtrhp.estatistica.api.enums.SexoEnum;
import br.com.vtrhp.estatistica.api.enums.SignosEnum;
import br.com.vtrhp.estatistica.api.service.ConjugeService;



@RestController
@RequestMapping("/api/conjuge")
@CrossOrigin(origins = "*")
public class ConjugeController {

	private static final Logger log = LoggerFactory.getLogger(ConjugeController.class);

	@Autowired
	private ConjugeService conjugeService;

	@PostMapping
	public ResponseEntity<Response<ConjugeDTO>> adicionar(@Valid @RequestBody ConjugeDTO conjugeDto,
			BindingResult result) throws ParseException {
		log.info("Adicionando conjuge: {}", conjugeDto.toString());
		Response<ConjugeDTO> response = new Response<ConjugeDTO>();
		validarConjuge(conjugeDto, result);
		Conjuge conjuge = this.converterDtoParaConjuge(conjugeDto, result);

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
			Optional<Conjuge> lanc = this.conjugeService.buscarPorId(conjugeDTO.getIdConjuge());
			if (lanc.isPresent()) {
				conjuge = lanc.get();
			} else {
				result.addError(new ObjectError("lancamento", "Lançamento não encontrado."));
			}
		} else {
			conjuge = new Conjuge();
			conjuge.getDocumentos().setIdDocumentos(conjugeDTO.getIdConjuge());
		}

		conjuge.setIdConjuge(conjugeDTO.getIdConjuge());
		conjuge.setNome(conjugeDTO.getNome());
		conjuge.setSobreNome(conjugeDTO.getSobreNome());
		conjuge.setAltura(conjugeDTO.getAltura());
		conjuge.setPeso(conjugeDTO.getPeso());
		conjuge.setCorOlhos(conjugeDTO.getCorOlhos());
		conjuge.setCorCabelo(conjugeDTO.getCorCabelo());
		conjuge.setTipoSanguineo(conjugeDTO.getTipoSanguineo());

		if (EnumUtils.isValidEnum(SexoEnum.class, conjugeDTO.getSexo())) {
			conjuge.setSexo(SexoEnum.valueOf(conjugeDTO.getSexo()));
		} else {
			result.addError(new ObjectError("tipo", "Tipo inválido."));
		}
		conjuge.setDataNascimento(conjugeDTO.getDataNascimento());
		conjuge.setHoraNascimento(conjugeDTO.getHoraNascimento());
		conjuge.setEstadoNascimento(conjugeDTO.getEstadoNascimento());
		conjuge.setCidadeNascimento(conjugeDTO.getCidadeNascimento());

		if (EnumUtils.isValidEnum(OrientacaoSexualEnum.class, conjugeDTO.getOrientacaoSexual())) {
			conjuge.setOrientacaoSexual(OrientacaoSexualEnum.valueOf(conjugeDTO.getOrientacaoSexual()));
		} else {
			result.addError(new ObjectError("tipo", "Tipo inválido."));
		}

		if (EnumUtils.isValidEnum(PaisesEnum.class, conjugeDTO.getPaisDeOrigem())) {
			conjuge.setPaisDeOrigem(PaisesEnum.valueOf(conjugeDTO.getPaisDeOrigem()));
		} else {
			result.addError(new ObjectError("tipo", "Tipo inválido."));
		}

		if (EnumUtils.isValidEnum(NacionalidadeEnum.class, conjugeDTO.getNacionalidade())) {
			conjuge.setNacionalidade(NacionalidadeEnum.valueOf(conjugeDTO.getNacionalidade()));
		} else {
			result.addError(new ObjectError("tipo", "Tipo inválido."));
		}
		conjuge.setAdotivo(conjugeDTO.getAdotivo());

		if (EnumUtils.isValidEnum(SignosEnum.class, conjugeDTO.getSigno())) {
			conjuge.setSigno(SignosEnum.valueOf(conjugeDTO.getSigno()));
		} else {
			result.addError(new ObjectError("tipo", "Tipo inválido."));
		}
		conjuge.setDescendencia(conjugeDTO.getDescendencia());
		conjuge.setTamanhoPe(conjugeDTO.getTamanhoPe());

		return conjuge;
	}

	private ConjugeDTO converterConjugeDto(Conjuge conjuge) {
		ConjugeDTO conjugeDTO = new ConjugeDTO();

		conjugeDTO.setIdConjuge(conjuge.getIdConjuge());
		conjugeDTO.setNome(conjuge.getNome());
		conjugeDTO.setSobreNome(conjuge.getSobreNome());
		conjugeDTO.setAltura(conjuge.getAltura());
		conjugeDTO.setPeso(conjuge.getPeso());
		conjugeDTO.setCorOlhos(conjuge.getCorOlhos());
		conjugeDTO.setCorCabelo(conjuge.getCorCabelo());
		conjugeDTO.setTipoSanguineo(conjuge.getTipoSanguineo());
		conjugeDTO.setSexo(conjuge.getSexo().toString());
		conjugeDTO.setDataNascimento(conjuge.getDataNascimento());
		conjugeDTO.setHoraNascimento(conjuge.getHoraNascimento());
		conjugeDTO.setEstadoNascimento(conjuge.getEstadoNascimento());
		conjugeDTO.setCidadeNascimento(conjuge.getCidadeNascimento());
		conjugeDTO.setOrientacaoSexual(conjuge.getOrientacaoSexual().toString());
		conjugeDTO.setPaisDeOrigem(conjuge.getPaisDeOrigem().toString());
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
		Optional<Conjuge> conjuge = this.conjugeService.buscarPorId(conjugeDTO.getIdConjuge());
		if (!conjuge.isPresent()) {
			result.addError(new ObjectError("conjuge", "Conjuge não encontrado. ID inexistente."));
		}
	}

}
