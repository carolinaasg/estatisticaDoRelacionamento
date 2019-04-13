package br.com.vtrhp.estatistica.api.entities;

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.vtrhp.estatistica.api.enums.AssuntosInteresseEnum;
import br.com.vtrhp.estatistica.api.enums.NivelENum;

public class AssuntosDeInteresse {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private NivelENum nivel;
	private AssuntosInteresseEnum assuntosInteresse;

	private LocalDate dataCriacao;
	private LocalDate dataAtualizacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public NivelENum getNivel() {
		return nivel;
	}

	public void setNivel(NivelENum nivel) {
		this.nivel = nivel;
	}

	public AssuntosInteresseEnum getAssuntosInteresse() {
		return assuntosInteresse;
	}

	public void setAssuntosInteresse(AssuntosInteresseEnum assuntosInteresse) {
		this.assuntosInteresse = assuntosInteresse;
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
