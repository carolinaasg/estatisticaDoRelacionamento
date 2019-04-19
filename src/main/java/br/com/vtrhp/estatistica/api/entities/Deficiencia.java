package br.com.vtrhp.estatistica.api.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import br.com.vtrhp.estatistica.api.enums.DeficienciaEnum;

@Entity
public class Deficiencia {
	@Id
	private Long idDeficiencia;
	@Enumerated(EnumType.STRING)
	private DeficienciaEnum tipo;
	private String descricao;

	private LocalDate dataCriacao;
	private LocalDate dataAtualizacao;

	public Long getIdDeficiencia() {
		return idDeficiencia;
	}

	public void setIdDeficiencia(Long idDeficiencia) {
		this.idDeficiencia = idDeficiencia;
	}

	public DeficienciaEnum getTipo() {
		return tipo;
	}

	public void setTipo(DeficienciaEnum tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
