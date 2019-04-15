package br.com.vtrhp.estatistica.api.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.javamoney.moneta.Money;


@Entity
public class Profissao {

	@Id
	private Long idProfissao;
	private Long idPessoa;
	private String nomeEmpresa;
	private String profissao;
	private String cargo;
	private String Descricao;
	private Integer tempoDeEmpresa;	
	private char gostaDoQueFaz;
	private char gostaDaEquipe;
	private char gostaDoChefe;
	private Money salarioBruto;
	private Money salarioLiquido;
	
	private LocalDate dataCriacao;
	private LocalDate dataAtualizacao;
	 

}
