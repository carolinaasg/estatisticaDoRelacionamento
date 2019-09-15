package br.com.vtrhp.estatistica.api.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
	   @RequestMapping(value = "/CadastroUsuario")
	   public String cadastroUsuario() {
	      return "CadastroUsuario";
	   }
}
