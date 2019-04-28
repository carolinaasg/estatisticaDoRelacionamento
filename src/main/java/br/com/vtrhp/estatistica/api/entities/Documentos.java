package br.com.vtrhp.estatistica.api.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "documentos")
public class Documentos implements Serializable {

	public Documentos() {

	}

	private static final long serialVersionUID = 2509789142018833918L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idDocumentos;	
	private String rg;
	private String cpf;
	private String habilitacao;

	private LocalDate dataCriacao;
	private LocalDate dataAtualizacao;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_conjuge", nullable = false)
	private Conjuge conjuge;

	@PreUpdate
	public void preUpdate() {
		dataAtualizacao = LocalDate.now();
	}

	@PrePersist
	public void prePersist() {
		final LocalDate atual = LocalDate.now();
		dataCriacao = atual;
		dataAtualizacao = atual;
	}

	@Column(name = "id_documento")
	public Long getIdDocumentos() {
		return idDocumentos;
	}

	public void setIdDocumentos(Long idDocumentos) {
		this.idDocumentos = idDocumentos;
	}


	@Column(name = "rg")
	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	@Column(name = "cpf")
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Column(name = "habilitacao")
	public String getHabilitacao() {
		return habilitacao;
	}

	public void setHabilitacao(String habilitacao) {
		this.habilitacao = habilitacao;
	}

	@Column(name = "data_criacao")
	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@Column(name = "data_atualizacao")
	public LocalDate getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDate dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public Conjuge getConjuge() {
		return conjuge;
	}

	public void setConjuge(Conjuge conjuge) {
		this.conjuge = conjuge;
	}

}
