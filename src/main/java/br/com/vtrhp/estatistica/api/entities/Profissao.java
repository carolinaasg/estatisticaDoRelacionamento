package br.com.vtrhp.estatistica.api.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.javamoney.moneta.Money;

@Entity
public class Profissao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4452861555374092394L;

	@Id
	private Long idProfissao;
	private Long idPessoa;
	private Long idAmigo;
	private Long IdFamilia;
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
	private Integer qtdSubordinados;
	private LocalDate dataDemissao;
	private LocalDate dataContratacao;

	@ManyToOne(fetch = FetchType.EAGER)
	private Pessoa pessoa;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Amigos amigos;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Familia familia;

	private LocalDate dataCriacao;
	private LocalDate dataAtualizacao;

	public Long getIdProfissao() {
		return idProfissao;
	}

	public void setIdProfissao(Long idProfissao) {
		this.idProfissao = idProfissao;
	}

	public Long getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public Integer getTempoDeEmpresa() {
		return tempoDeEmpresa;
	}

	public void setTempoDeEmpresa(Integer tempoDeEmpresa) {
		this.tempoDeEmpresa = tempoDeEmpresa;
	}

	public char getGostaDoQueFaz() {
		return gostaDoQueFaz;
	}

	public void setGostaDoQueFaz(char gostaDoQueFaz) {
		this.gostaDoQueFaz = gostaDoQueFaz;
	}

	public char getGostaDaEquipe() {
		return gostaDaEquipe;
	}

	public void setGostaDaEquipe(char gostaDaEquipe) {
		this.gostaDaEquipe = gostaDaEquipe;
	}

	public char getGostaDoChefe() {
		return gostaDoChefe;
	}

	public void setGostaDoChefe(char gostaDoChefe) {
		this.gostaDoChefe = gostaDoChefe;
	}

	public Money getSalarioBruto() {
		return salarioBruto;
	}

	public void setSalarioBruto(Money salarioBruto) {
		this.salarioBruto = salarioBruto;
	}

	public Money getSalarioLiquido() {
		return salarioLiquido;
	}

	public void setSalarioLiquido(Money salarioLiquido) {
		this.salarioLiquido = salarioLiquido;
	}

	public Integer getQtdSubordinados() {
		return qtdSubordinados;
	}

	public void setQtdSubordinados(Integer qtdSubordinados) {
		this.qtdSubordinados = qtdSubordinados;
	}

	public LocalDate getDataDemissao() {
		return dataDemissao;
	}

	public void setDataDemissao(LocalDate dataDemissao) {
		this.dataDemissao = dataDemissao;
	}

	public LocalDate getDataContratacao() {
		return dataContratacao;
	}

	public void setDataContratacao(LocalDate dataContratacao) {
		this.dataContratacao = dataContratacao;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public LocalDate getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDate dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public Long getIdAmigo() {
		return idAmigo;
	}

	public void setIdAmigo(Long idAmigo) {
		this.idAmigo = idAmigo;
	}

	public Amigos getAmigos() {
		return amigos;
	}

	public void setAmigos(Amigos amigos) {
		this.amigos = amigos;
	}

	public Long getIdFamilia() {
		return IdFamilia;
	}

	public void setIdFamilia(Long idFamilia) {
		IdFamilia = idFamilia;
	}

	public Familia getFamilia() {
		return familia;
	}

	public void setFamilia(Familia familia) {
		this.familia = familia;
	}

	@PreUpdate
	public void preUpdate() {
		dataAtualizacao = LocalDate.now();
	}

	@PrePersist
	public void prePersist() {
		final LocalDate atual = LocalDate.now();
		dataAtualizacao = atual;
	}

}
