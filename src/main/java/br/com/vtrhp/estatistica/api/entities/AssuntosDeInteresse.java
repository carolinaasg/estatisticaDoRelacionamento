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
public class AssuntosDeInteresse implements Serializable {

	private static final long serialVersionUID = -1535328936453273480L;

	@Id
	private Long idAssuntosDeInteresse;
	private Long idPessoa;
	private Long idFamilia;
	private Long idAmigo;

	private NivelENum nivel;
	private AssuntosInteresseEnum assuntosInteresse;

	@ManyToOne(fetch = FetchType.EAGER)
	private Pessoa pessoa;

	@ManyToOne(fetch = FetchType.EAGER)
	private Amigos amigo;

	@ManyToOne(fetch = FetchType.EAGER)
	private Familia familia;

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

	public Long getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
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

	public Familia getFamilia() {
		return familia;
	}

	public void setFamilia(Familia familia) {
		this.familia = familia;
	}

	public Amigos getAmigo() {
		return amigo;
	}

	public void setAmigo(Amigos amigo) {
		this.amigo = amigo;
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
