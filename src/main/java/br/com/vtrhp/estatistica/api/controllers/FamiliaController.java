package br.com.vtrhp.estatistica.api.controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.commons.lang3.EnumUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vtrhp.estatistica.api.dtos.FamiliaDTO;
import br.com.vtrhp.estatistica.api.entities.Familia;
import br.com.vtrhp.estatistica.api.enums.NacionalidadeEnum;
import br.com.vtrhp.estatistica.api.enums.OrientacaoSexualEnum;
import br.com.vtrhp.estatistica.api.enums.PaisesEnum;
import br.com.vtrhp.estatistica.api.enums.SexoEnum;
import br.com.vtrhp.estatistica.api.enums.SignosEnum;
import br.com.vtrhp.estatistica.api.response.Response;
import br.com.vtrhp.estatistica.api.service.FamiliaService;

@RestController
@RequestMapping("/api/familia")
@CrossOrigin(origins = "*")
public class FamiliaController {

	private static final Logger log = LoggerFactory.getLogger(FamiliaController.class);
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	@Autowired
	private FamiliaService familiaService;

	@PostMapping(path = "/adicionar", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<FamiliaDTO>> adicionar(@Valid @RequestBody FamiliaDTO familiaDTO,
			BindingResult result) throws ParseException {

		log.info("Adicionando Familia {}", familiaDTO.toString());
		Response<FamiliaDTO> response = new Response<FamiliaDTO>();

		log.info("Response criado: {}", response.toString());

		Familia familia = this.converterDtoParaFamilia(familiaDTO, result);

		log.info("Convertido para Familia: {}", familia.toString());

		if (result.hasErrors()) {
			log.error("Erro validando Familia: {}", result.getAllErrors());
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		familia = familiaService.persistir(familia);
		familiaDTO.setIdFamilia(familia.getIdFamilia());

		response.setData(this.converterFamiliaDto(familia));

		return ResponseEntity.ok(response);
	}

	private FamiliaDTO converterFamiliaDto(Familia familia) {
		FamiliaDTO familiaDTO = new FamiliaDTO();

		familiaDTO.setIdFamilia(familia.getIdFamilia());
		familiaDTO.setNome(familia.getNome());
		familiaDTO.setAltura(familia.getAltura());
		familiaDTO.setPeso(familia.getPeso());
		familiaDTO.setCorOlhos(familia.getCorOlhos());
		familiaDTO.setCorCabelo(familia.getCorCabelo());
		familiaDTO.setTipoSanguineo(familia.getTipoSanguineo());
		familiaDTO.setSexo(familia.getSexo().toString());
		familiaDTO.setDataNascimento(String.valueOf(familia.getDataNascimento()));
		familiaDTO.setHoraNascimento(String.valueOf(familia.getHoraNascimento()));
		familiaDTO.setEstadoNascimento(familia.getEstadoNascimento());
		familiaDTO.setCidadeNascimento(familia.getCidadeNascimento());
		familiaDTO.setOrientacaoSexual(familia.getOrientacaoSexual().toString());
		familiaDTO.setPaisOrigem(familia.getPaisOrigem().toString());
		familiaDTO.setNacionalidade(familia.getNacionalidade().toString());
		familiaDTO.setAdotivo(familia.getAdotivo());
		familiaDTO.setSigno(familia.getSigno().toString());
		familiaDTO.setDescendencia(familia.getDescendencia());
		familiaDTO.setTamanhoPe(familia.getTamanhoPe());
		familiaDTO.setGrauParentesco(familia.getGrauParentesco());

		return familiaDTO;
	}

	private Familia converterDtoParaFamilia(@Valid FamiliaDTO familiaDTO, BindingResult result) {
		Familia familia = new Familia();

		if (familiaDTO.getIdFamilia() != null && !"".equals(familiaDTO.getIdFamilia())) {
			Optional<Familia> lanc = this.familiaService.buscarPorId(familiaDTO.getIdFamilia());
			if (lanc.isPresent()) {
				familia = lanc.get();
			} else {
				result.addError(new ObjectError("familia", "Familia não encontrado."));
			}
		} else {
			familia = new Familia();

			if (familiaDTO.getIdFamilia() != null && !"".equals(familiaDTO.getIdFamilia()))
				familia.setIdFamilia(familiaDTO.getIdFamilia());

			familia.setNome(familiaDTO.getNome());
			familia.setAltura(familiaDTO.getAltura());
			familia.setPeso(familiaDTO.getPeso());
			familia.setCorOlhos(familiaDTO.getCorOlhos());
			familia.setCorCabelo(familiaDTO.getCorCabelo());
			familia.setTipoSanguineo(familiaDTO.getTipoSanguineo());

			if (EnumUtils.isValidEnum(SexoEnum.class, familiaDTO.getSexo())) {
				familia.setSexo(SexoEnum.valueOf(familiaDTO.getSexo()));
			} else {
				result.addError(new ObjectError("Sexo", "Sexo inválido."));
			}
			familia.setDataNascimento(LocalDate.parse(familiaDTO.getDataNascimento(), formatter));
			familia.setHoraNascimento(
					LocalTime.parse(familiaDTO.getHoraNascimento(), DateTimeFormatter.ofPattern("HH:mm")));
			familia.setEstadoNascimento(familiaDTO.getEstadoNascimento());
			familia.setCidadeNascimento(familiaDTO.getCidadeNascimento());

			if (EnumUtils.isValidEnum(OrientacaoSexualEnum.class, familiaDTO.getOrientacaoSexual())) {
				familia.setOrientacaoSexual(OrientacaoSexualEnum.valueOf(familiaDTO.getOrientacaoSexual()));
			} else {
				result.addError(new ObjectError("Orientacao Sexual", "Orientacao Sexual inválido."));
			}

			if (EnumUtils.isValidEnum(PaisesEnum.class, familiaDTO.getPaisOrigem())) {
				familia.setPaisOrigem(PaisesEnum.valueOf(familiaDTO.getPaisOrigem()));
			} else {
				result.addError(new ObjectError("Pais de Origem", "Pais de Origem inválido."));
			}

			if (EnumUtils.isValidEnum(NacionalidadeEnum.class, familiaDTO.getNacionalidade())) {
				familia.setNacionalidade(NacionalidadeEnum.valueOf(familiaDTO.getNacionalidade()));
			} else {
				result.addError(new ObjectError("Nacionalidade", "Nacionalidade inválida."));
			}
			familia.setAdotivo(familiaDTO.getAdotivo());

			if (EnumUtils.isValidEnum(SignosEnum.class, familiaDTO.getSigno())) {
				familia.setSigno(SignosEnum.valueOf(familiaDTO.getSigno()));
			} else {
				result.addError(new ObjectError("Signo", "Signo inválido."));
			}
			familia.setDescendencia(familiaDTO.getDescendencia());
			familia.setTamanhoPe(familiaDTO.getTamanhoPe());
			familia.setGrauParentesco(familiaDTO.getGrauParentesco());
		}

		return familia;
	}

}
