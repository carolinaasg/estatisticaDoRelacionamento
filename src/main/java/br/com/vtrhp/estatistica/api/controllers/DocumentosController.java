package br.com.vtrhp.estatistica.api.controllers;

import java.text.ParseException;
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

import br.com.vtrhp.estatistica.api.dtos.DocumentosDTO;
import br.com.vtrhp.estatistica.api.entities.Documentos;
import br.com.vtrhp.estatistica.api.response.Response;
import br.com.vtrhp.estatistica.api.service.ConjugeService;
import br.com.vtrhp.estatistica.api.service.DocumentosService;
import br.com.vtrhp.estatistica.api.service.UsuarioService;

@RestController
@RequestMapping("/api/documentos")
@CrossOrigin(origins = "*")
public class DocumentosController {

	private static final Logger log = LoggerFactory.getLogger(ConjugeController.class);
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	@Autowired
	private DocumentosService documentosService;
	@Autowired
	private ConjugeService conjugeService;
	@Autowired
	private UsuarioService usuarioService;

	@PostMapping(path = "/adicionar/{tipo}/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<DocumentosDTO>> adicionar(@Valid @RequestBody DocumentosDTO documentosDto,
			@PathVariable("tipo") String tipo, @PathVariable("id") Long id, BindingResult result)
			throws ParseException {

		log.info("Adicionando Documentos: {}", documentosDto.toString());

		Response<DocumentosDTO> response = new Response<DocumentosDTO>();

		log.info("Response foi criado: {}", response.toString());

		// validarConjuge(conjugeDto, result);
		try {

			Documentos documento = this.converterDtoParaDocumento(documentosDto, result);
			if (tipo == null || "".equals(tipo)) {
				log.error("Tipo não pode ser vazio: {}", tipo);
				return ResponseEntity.badRequest().body(response);
			} else {
				if (tipo.equals("usuario")) {
					documento.setUsuario(this.usuarioService.buscarPorId(id).get());					
				}else if (tipo.equals("conjuge")) {
					documento.setConjuge(this.conjugeService.buscarPorId(id).get());					
				}else {
					log.error("Tipo não pode ser diferente de usuario ou conjuge: {}", tipo);
					return ResponseEntity.badRequest().body(response);
				}
			}

			log.info("Convertido para Documento: {}", documento.toString());

			if (result.hasErrors()) {
				log.error("Erro validando documentos: {}", result.getAllErrors());
				result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
				return ResponseEntity.badRequest().body(response);
			}

			documento = this.documentosService.persistir(documento);

			response.setData(this.converterDocumentosDto(documento));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(response);
		}
		return ResponseEntity.ok(response);
	}

	private Documentos converterDtoParaDocumento(DocumentosDTO documentosDTO, BindingResult result)
			throws ParseException {

		Documentos documento = new Documentos();

		if (documentosDTO.getIdDocumentos() != null) {
			Optional<Documentos> lanc = this.documentosService.buscarPorId(documentosDTO.getIdDocumentos());
			if (lanc.isPresent()) {
				documento = lanc.get();
			} else {
				result.addError(new ObjectError("Documento", "Documento não encontrado."));
			}
		} else {
			documento = new Documentos();
		}
		if (documentosDTO.getIdDocumentos() != null && !"".equals(documentosDTO.getIdDocumentos()))
			documento.setIdDocumentos(documentosDTO.getIdDocumentos());

		documento.setRg(documentosDTO.getRg());
		documento.setCpf(documentosDTO.getCpf());
		documento.setHabilitacao(documentosDTO.getHabilitacao());
		return documento;
	}

	private DocumentosDTO converterDocumentosDto(Documentos documento) {
		DocumentosDTO documentoDTO = new DocumentosDTO();
		documentoDTO.setRg(documento.getRg());
		documentoDTO.setCpf(documento.getCpf());
		documentoDTO.setHabilitacao(documento.getHabilitacao());

		return documentoDTO;
	}

}
