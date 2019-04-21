package br.com.vtrhp.estatistica.api.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import br.com.vtrhp.estatistica.api.enums.AssuntosInteresseEnum;
import br.com.vtrhp.estatistica.api.enums.NivelENum;

@Entity
public class AssuntosDeInteresse implements Serializable {

	private static final long serialVersionUID = -1535328936453273480L;

	@Id
	private Long idAssuntosDeInteresse;
	private Long idConjuge;
	private Long idFamilia;
	private Long idAmigo;

	private NivelENum nivel;
	private AssuntosInteresseEnum assuntosInteresse;



	private LocalDate dataCriacao;
	private LocalDate dataAtualizacao;

	public Long getIdAssuntosDeInteresse() {
		return idAssuntosDeInteresse;
	}

	public void setIdAssuntosDeInteresse(Long idAssuntosDeInteresse) {
		this.idAssuntosDeInteresse = idAssuntosDeInteresse;
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



	public Long getIdConjuge() {
		return idConjuge;
	}

	public void setIdConjuge(Long idConjuge) {
		this.idConjuge = idConjuge;
	}

	public Long getIdFamilia() {
		return idFamilia;
	}

	public void setIdFamilia(Long idFamilia) {
		this.idFamilia = idFamilia;
	}

	public Long getIdAmigo() {
		return idAmigo;
	}

	public void setIdAmigo(Long idAmigo) {
		this.idAmigo = idAmigo;
	}



}
