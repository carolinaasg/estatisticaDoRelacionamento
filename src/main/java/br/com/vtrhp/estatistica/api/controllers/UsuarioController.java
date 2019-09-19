package br.com.vtrhp.estatistica.api.controllers;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.EnumUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.vtrhp.estatistica.api.dtos.UsuarioDTO;
import br.com.vtrhp.estatistica.api.entities.Usuario;
import br.com.vtrhp.estatistica.api.enums.NacionalidadeEnum;
import br.com.vtrhp.estatistica.api.enums.OrientacaoSexualEnum;
import br.com.vtrhp.estatistica.api.enums.PaisesEnum;
import br.com.vtrhp.estatistica.api.enums.SexoEnum;
import br.com.vtrhp.estatistica.api.enums.SignosEnum;
import br.com.vtrhp.estatistica.api.service.UsuarioService;

@RestController
@CrossOrigin(origins = "*")
public class UsuarioController {

	private static final Logger log = LoggerFactory.getLogger(UsuarioController.class);
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	@RequestMapping("/")
	public String UsuarioController() {
		return "cadastroUsuario";
	}

	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(value = "/adicionar", method = RequestMethod.POST)
	public ModelAndView  adicionar(@ModelAttribute Usuario usuario,
			BindingResult result, Model model) throws ParseException {

		ModelAndView mav = new ModelAndView();
		List<Usuario> listaUsuario = new ArrayList<Usuario>();
		try {

			log.info("Adicionando usuario: {}", usuario.toString());

			mav.setViewName("cadastroUsuario");
			//Usuario usuario = this.converterDtoParaUsuario(usuarioDTO, result);

			usuario = usuarioService.persistir(usuario);
			
			listaUsuario.add(usuario);
	        mav.addObject("listaUsuario", listaUsuario);

		} catch (Exception e) {
			log.error("Erro ao adicionar um usuario {}", usuario.toString());
			e.printStackTrace();
		}
		return mav;

	}

	private Usuario converterDtoParaUsuario(UsuarioDTO usuarioDTO, BindingResult result) throws ParseException {
		Usuario usuario = new Usuario();

		if (usuarioDTO.getIdUsuario() != null) {
			Optional<Usuario> lanc = this.usuarioService.buscarPorId(usuarioDTO.getIdUsuario());
			if (lanc.isPresent()) {
				usuario = lanc.get();
			} else {
				result.addError(new ObjectError("conjuge", "Conjuge não encontrado."));
			}
		} else {
			usuario = new Usuario();
			if (usuarioDTO.getIdUsuario() != null && !"".equals(usuarioDTO.getIdUsuario()))
				usuario.setIdUsuario(usuarioDTO.getIdUsuario());

			usuario.setNome(usuarioDTO.getNome());
			usuario.setAltura(usuarioDTO.getAltura());
			usuario.setPeso(usuarioDTO.getPeso());
			usuario.setCorOlhos(usuarioDTO.getCorOlhos());
			usuario.setCorCabelo(usuarioDTO.getCorCabelo());
			usuario.setTipoSanguineo(usuarioDTO.getTipoSanguineo());

			if (EnumUtils.isValidEnum(SexoEnum.class, usuarioDTO.getSexo())) {
				usuario.setSexo(SexoEnum.valueOf(usuarioDTO.getSexo()));
			} else {
				result.addError(new ObjectError("Sexo", "Sexo inválido."));
			}
			usuario.setDataNascimento(LocalDate.parse(usuarioDTO.getDataNascimento(), formatter));
			usuario.setHoraNascimento(
					LocalTime.parse(usuarioDTO.getHoraNascimento(), DateTimeFormatter.ofPattern("HH:mm")));
			usuario.setEstadoNascimento(usuarioDTO.getEstadoNascimento());
			usuario.setCidadeNascimento(usuarioDTO.getCidadeNascimento());

			if (EnumUtils.isValidEnum(OrientacaoSexualEnum.class, usuarioDTO.getOrientacaoSexual())) {
				usuario.setOrientacaoSexual(OrientacaoSexualEnum.valueOf(usuarioDTO.getOrientacaoSexual()));
			} else {
				result.addError(new ObjectError("Orientacao Sexual", "Orientacao Sexual inválido."));
			}

			if (EnumUtils.isValidEnum(PaisesEnum.class, usuarioDTO.getPaisDeOrigem())) {
				usuario.setPaisOrigem(PaisesEnum.valueOf(usuarioDTO.getPaisDeOrigem()));
			} else {
				result.addError(new ObjectError("Pais de Origem", "Pais de Origem inválido."));
			}

			if (EnumUtils.isValidEnum(NacionalidadeEnum.class, usuarioDTO.getNacionalidade())) {
				usuario.setNacionalidade(NacionalidadeEnum.valueOf(usuarioDTO.getNacionalidade()));
			} else {
				result.addError(new ObjectError("Nacionalidade", "Nacionalidade inválida."));
			}
			usuario.setAdotivo(usuarioDTO.getAdotivo());

			if (EnumUtils.isValidEnum(SignosEnum.class, usuarioDTO.getSigno())) {
				usuario.setSigno(SignosEnum.valueOf(usuarioDTO.getSigno()));
			} else {
				result.addError(new ObjectError("Signo", "Signo inválido."));
			}
			usuario.setDescendencia(usuarioDTO.getDescendencia());
			usuario.setTamanhoPe(usuarioDTO.getTamanhoPe());
		}
		
		return usuario;
	}

	private UsuarioDTO converterUsuarioDto(Usuario usuario) {
		UsuarioDTO usuarioDTO = new UsuarioDTO();

		usuarioDTO.setIdUsuario(usuario.getIdUsuario());
		usuarioDTO.setNome(usuario.getNome());
		usuarioDTO.setAltura(usuario.getAltura());
		usuarioDTO.setPeso(usuario.getPeso());
		usuarioDTO.setCorOlhos(usuario.getCorOlhos());
		usuarioDTO.setCorCabelo(usuario.getCorCabelo());
		usuarioDTO.setTipoSanguineo(usuario.getTipoSanguineo());
		usuarioDTO.setSexo(usuario.getSexo().toString());
		usuarioDTO.setDataNascimento(String.valueOf(usuario.getDataNascimento()));
		usuarioDTO.setHoraNascimento(String.valueOf(usuario.getHoraNascimento()));
		usuarioDTO.setEstadoNascimento(usuario.getEstadoNascimento());
		usuarioDTO.setCidadeNascimento(usuario.getCidadeNascimento());
		usuarioDTO.setOrientacaoSexual(usuario.getOrientacaoSexual().toString());
		usuarioDTO.setPaisDeOrigem(usuario.getPaisOrigem().toString());
		usuarioDTO.setNacionalidade(usuario.getNacionalidade().toString());
		usuarioDTO.setAdotivo(usuario.getAdotivo());
		usuarioDTO.setSigno(usuario.getSigno().toString());
		usuarioDTO.setDescendencia(usuario.getDescendencia());
		usuarioDTO.setTamanhoPe(usuario.getTamanhoPe());

		return usuarioDTO;
	}

}
