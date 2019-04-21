package br.com.vtrhp.estatistica.api.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Entity
public class Dia implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 261190663710808144L;
	
	@Id
	private Long idDia;
	private Double qtdHorasTrabalhadas;
	private Double qtdHorasDeSono;
	private LocalTime horaAlmoco;
	private LocalTime horaJanta;
	private String descricao;
	private String pontosPositivos;
	private String pontosNegativos;


	private LocalDate dataCriacao;
	private LocalDate dataAtualizacao;

	public Long getIdDia() {
		return idDia;
	}

	public void setIdDia(Long idDia) {
		this.idDia = idDia;
	}

	public Double getQtdHorasTrabalhadas() {
		return qtdHorasTrabalhadas;
	}

	public void setQtdHorasTrabalhadas(Double qtdHorasTrabalhadas) {
		this.qtdHorasTrabalhadas = qtdHorasTrabalhadas;
	}

	public Double getQtdHorasDeSono() {
		return qtdHorasDeSono;
	}

	public void setQtdHorasDeSono(Double qtdHorasDeSono) {
		this.qtdHorasDeSono = qtdHorasDeSono;
	}

	public LocalTime getHoraAlmoco() {
		return horaAlmoco;
	}

	public void setHoraAlmoco(LocalTime horaAlmoco) {
		this.horaAlmoco = horaAlmoco;
	}

	public LocalTime getHoraJanta() {
		return horaJanta;
	}

	public void setHoraJanta(LocalTime horaJanta) {
		this.horaJanta = horaJanta;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPontosPositivos() {
		return pontosPositivos;
	}

	public void setPontosPositivos(String pontosPositivos) {
		this.pontosPositivos = pontosPositivos;
	}

	public String getPontosNegativos() {
		return pontosNegativos;
	}

	public void setPontosNegativos(String pontosNegativos) {
		this.pontosNegativos = pontosNegativos;
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
