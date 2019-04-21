package br.com.vtrhp.estatistica.api.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Entity
public class Objetivos implements Serializable {

	private static final long serialVersionUID = 5998658162806323475L;

	@Id
	private Long idObjetivos;
	private String descricao;
	private String prazoEmAnos;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private LocalDate dataCriacao;
	private LocalDate dataAtualizacao;

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

	public Long getIdObjetivos() {
		return idObjetivos;
	}

	public void setIdObjetivos(Long idObjetivos) {
		this.idObjetivos = idObjetivos;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPrazoEmAnos() {
		return prazoEmAnos;
	}

	public void setPrazoEmAnos(String prazoEmAnos) {
		this.prazoEmAnos = prazoEmAnos;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
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

}
