package br.com.vtrhp.estatistica.api.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import br.com.vtrhp.estatistica.api.enums.AssuntosInteresseEnum;
import br.com.vtrhp.estatistica.api.enums.NivelENum;

@Entity
public class AssuntosDeInteresse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1535328936453273480L;

	@Id	
	private Long idAssuntosDeInteresse;

	private NivelENum nivel;
	private AssuntosInteresseEnum assuntosInteresse;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Pessoa pessoa;

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
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
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
