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

import com.kazale.pontointeligente.api.dtos.LancamentoDto;
import com.kazale.pontointeligente.api.entities.Lancamento;
import com.kazale.pontointeligente.api.enums.TipoEnum;

import br.com.vtrhp.estatistica.api.dtos.ConjugeDTO;
import br.com.vtrhp.estatistica.api.entities.Conjuge;
import br.com.vtrhp.estatistica.api.service.ConjugeService;

@RestController
@RequestMapping("/api/conjuge")
@CrossOrigin(origins = "*")
public class ConjugeController {
	
	private static final Logger log = LoggerFactory.getLogger(ConjugeController.class);
	
	@Autowired
	private ConjugeService conjugeService;
	
	@PostMapping
	public ResponseEntity<Response<ConjugeDTO>> adicionar(@Valid @RequestBody ConjugeDTO lancamentoDto,
			BindingResult result) throws ParseException {
		log.info("Adicionando lançamento: {}", lancamentoDto.toString());
		Response<ConjugeDTO> response = new Response<ConjugeDTO>();
		validarFuncionario(lancamentoDto, result);
		Conjuge lancamento = this.converterDtoParaLancamento(lancamentoDto, result);

		if (result.hasErrors()) {
			log.error("Erro validando lançamento: {}", result.getAllErrors());
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		lancamento = this.lancamentoService.persistir(lancamento);
		response.setData(this.converterLancamentoDto(lancamento));
		return ResponseEntity.ok(response);
	}
	
	
	private Lancamento converterDtoParaLancamento(ConjugeDTO conjugeDTO, BindingResult result) throws ParseException {
		
		Conjuge conjuge = new Conjuge();

		if (conjugeDTO.getIdConjuge().isPresent()) {
			Optional<Conjuge> lanc = this.conjugeService.buscarPorId(conjugeDTO.getIdConjuge().get());
			if (lanc.isPresent()) {
				conjuge = lanc.get();
			} else {
				result.addError(new ObjectError("lancamento", "Lançamento não encontrado."));
			}
		} else {
			conjuge = new Conjuge( );
			conjuge.getDocumentos().setIdDocumentos(conjugeDTO.getIdConjuge());
		}

		lancamento.setDescricao(conjugeDTO.getDescricao());
		lancamento.setLocalizacao(conjugeDTO.getLocalizacao());
		lancamento.setData(this.dateFormat.parse(conjugeDTO.getData()));

		
		if (EnumUtils.isValidEnum(TipoEnum.class, lancamentoDto.getTipo())) {
			lancamento.setTipo(TipoEnum.valueOf(lancamentoDto.getTipo()));
		} else {
			result.addError(new ObjectError("tipo", "Tipo inválido."));
		}

		return conjuge;
	}
	
	private LancamentoDto converterLancamentoDto(Lancamento lancamento) {
		LancamentoDto lancamentoDto = new LancamentoDto();
		lancamentoDto.setId(Optional.of(lancamento.getId()));
		lancamentoDto.setData(this.dateFormat.format(lancamento.getData()));
		lancamentoDto.setTipo(lancamento.getTipo().toString());
		lancamentoDto.setDescricao(lancamento.getDescricao());
		lancamentoDto.setLocalizacao(lancamento.getLocalizacao());
		lancamentoDto.setFuncionarioId(lancamento.getFuncionario().getId());

		return lancamentoDto;
	}

}
