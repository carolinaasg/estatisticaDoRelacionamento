package br.com.vtrhp.estatistica.api.controllers;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vtrhp.estatistica.api.dtos.VeiculoDTO;
import br.com.vtrhp.estatistica.api.entities.Veiculo;
import br.com.vtrhp.estatistica.api.response.Response;
import br.com.vtrhp.estatistica.api.service.AmigosService;
import br.com.vtrhp.estatistica.api.service.ConjugeService;
import br.com.vtrhp.estatistica.api.service.FamiliaService;
import br.com.vtrhp.estatistica.api.service.UsuarioService;
import br.com.vtrhp.estatistica.api.service.VeiculoService;

@RequestMapping("/api/veiculo")
@RestController
@CrossOrigin("*")
public class VeiculoController {
	
	private static final Logger log = LoggerFactory.getLogger(Veiculo.class);
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private FamiliaService familiaService;
	@Autowired
	private ConjugeService conjugeService;
	@Autowired
	private AmigosService amigosService;
	@Autowired
	private VeiculoService veiculoService;
	
	
	@PostMapping(path = "/adicionar/{tipo}/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<VeiculoDTO>> adicionar(@Valid @RequestBody VeiculoDTO veiculoDTO,
			@PathVariable("tipo") String tipo, @PathVariable("id") Long id, BindingResult result) throws ParseException {

		Response<VeiculoDTO> response = new Response<VeiculoDTO>();

		try {

			log.info("Adicionando usuario: {}", veiculoDTO.toString());

			log.info("Response foi criado: {}", response.toString());

			Veiculo veiculo = this.converterDtoParaVeiculo(veiculoDTO, result);

			log.info("Convertido para Usuario: {}", veiculo.toString());

			if (result.hasErrors()) {
				log.error("Erro validando Usuario: {} ", result.getAllErrors());
				result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
				return ResponseEntity.badRequest().body(response);
			}
			
			if ((tipo == null || "".equals(tipo)) && (id == null )) {
				log.error("Tipo ou Id não foi informado.");
				return ResponseEntity.badRequest().body(response);
			} else {
				if (tipo.equals("usuario")) {
					log.info("Buscando usuario");
					if (veiculoService.buscarPorId(id).isPresent()) {
						veiculo.setUsuario(usuarioService.buscarPorId(id).get());						
					} else {
						log.error("Id do Usuario não encontrado", id.toString());
						return ResponseEntity.badRequest().body(response);
					}
				} else if (tipo.equals("conjuge")) {
					log.info("Buscando conjuge");
					if (conjugeService.buscarPorId(id).isPresent()) {
						veiculo.setConjuge(conjugeService.buscarPorId(id).get());						
					} else {
						log.error("Id do Conjuge não encontrado", id.toString());
						return ResponseEntity.badRequest().body(response);
					}
				} else if (tipo.equals("familia")) {
					log.info("Buscando familia");
					if (familiaService.buscarPorId(id).isPresent()) {
						veiculo.setFamilia(familiaService.buscarPorId(id).get());						
					} else {
						log.error("Id do Familia não encontrado", id.toString());
						return ResponseEntity.badRequest().body(response);
					}
				} else {
					log.info("Buscando amigos");
					if (amigosService.buscarPorId(id).isPresent()) {
						veiculo.setAmigos(amigosService.buscarPorId(id).get());						
					} else {
						log.error("Id do Amigos não encontrado", id.toString());
						return ResponseEntity.badRequest().body(response);
					}
				}
			}

			veiculo = veiculoService.persistir(veiculo);
			
			response.setData(this.converterVeiculoDTO(veiculo));

		} catch (Exception e) {
			log.error("Erro ao adicionar um usuario {}", veiculoDTO.toString());
			e.printStackTrace();
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);

	}
	
	
	private Veiculo converterDtoParaVeiculo(VeiculoDTO veiculoDTO, BindingResult result) {
		Veiculo veiculo = new Veiculo();
		
		if(veiculoDTO.getIdVeiculo()!=null) {
			Optional<Veiculo> veic =  this.veiculoService.buscarPorId(veiculoDTO.getIdVeiculo());
			if(veic.isPresent()) {
				veiculo = veic.get();
			}else {
				result.addError(new ObjectError("Veiculo", "Veiculo não encontrado"));
			}
		}else {
			veiculo = new Veiculo();
			
			if(veiculoDTO.getIdVeiculo()!=null)veiculo.setIdVeiculo(veiculoDTO.getIdVeiculo());
			
			veiculo.setPlaca(veiculoDTO.getPlaca());
			veiculo.setRenavam(veiculoDTO.getRenavam());
			veiculo.setQtPortas(veiculoDTO.getQtPortas());
			veiculo.setMotor(veiculoDTO.getMotor());
			veiculo.setDataCompra(LocalDate.parse(veiculoDTO.getDataCompra(),formatter));
			veiculo.setDataVenda(LocalDate.parse(veiculoDTO.getDataVenda(),formatter));
			veiculo.setTipo(veiculoDTO.getTipo());
			veiculo.setMarca(veiculoDTO.getMarca());
			veiculo.setModelo(veiculoDTO.getModelo());
			veiculo.setAnoFabricacao(veiculoDTO.getAnoFabricacao());
			veiculo.setAnoModelo(veiculoDTO.getAnoModelo());
			veiculo.setQuilometragem(Integer.valueOf(veiculoDTO.getQuilometragem()));			
		}
		return veiculo;		
	}
	
	private VeiculoDTO converterVeiculoDTO(Veiculo veiculo) {
		VeiculoDTO veiculoDTO = new VeiculoDTO();
		log.info("Convertendo Veiculo para VeiculoDTO", veiculo.toString());
		if(veiculo.getIdVeiculo() !=null) veiculoDTO.setIdVeiculo(veiculo.getIdVeiculo());
		
		veiculoDTO.setPlaca(veiculo.getPlaca());
		veiculoDTO.setRenavam(veiculo.getRenavam());
		veiculoDTO.setQtPortas(veiculo.getQtPortas());
		veiculoDTO.setMotor(veiculo.getMotor());
		veiculoDTO.setDataCompra(String.valueOf(veiculo.getDataCompra()));
		veiculoDTO.setDataVenda(String.valueOf(veiculo.getDataVenda()));
		veiculoDTO.setTipo(veiculo.getTipo());
		veiculoDTO.setMarca(veiculo.getMarca());
		veiculoDTO.setModelo(veiculo.getModelo());
		veiculoDTO.setAnoFabricacao(veiculo.getAnoFabricacao());
		veiculoDTO.setAnoModelo(veiculo.getAnoModelo());
		veiculoDTO.setQuilometragem(veiculo.getQuilometragem());
		
		log.info("Veiculo convertido para VeiculoDTO", veiculoDTO.toString());
		
		return veiculoDTO;
		
	}

}
