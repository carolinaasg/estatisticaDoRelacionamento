package br.com.vtrhp.estatistica.api.entities;

import javax.persistence.Entity;

import org.javamoney.moneta.Money;


@Entity
public class Profissao {

	private String Empresa;
	private Integer tempoDeEmpresa;
	private String trabalhaNaAreaDeFormacao;
	private String gostaDoQueFazString;
	private String gostaDaEquipe;
	private String gostaDoChefe;
	private Money renda;
	 

}
