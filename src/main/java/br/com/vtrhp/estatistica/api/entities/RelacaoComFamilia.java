package br.com.vtrhp.estatistica.api.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import br.com.vtrhp.estatistica.api.enums.StatusRelacaoEnum;

@Entity
public class RelacaoComFamilia implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8636866510768040543L;
	
	@Id
	private Long idRelacaoFamilia;
	private Long idFamilia;
	private String nome;
	private String grauDeParentesco;
	private String descricao;
	private StatusRelacaoEnum statusRelacao;
	private LocalDate dataEvento;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Familia familia;
	
	// Manutenção da Tabela	
	private LocalDate dataCriacao;	
	private LocalDate dataAtualizacao;
	
	public Long getIdRelacaoFamilia() {
		return idRelacaoFamilia;
	}

	public void setIdRelacaoFamilia(Long idRelacaoFamilia) {
		this.idRelacaoFamilia = idRelacaoFamilia;
	}

	public Long getIdFamilia() {
		return idFamilia;
	}

	public void setIdFamilia(Long idFamilia) {
		this.idFamilia = idFamilia;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGrauDeParentesco() {
		return grauDeParentesco;
	}

	public void setGrauDeParentesco(String grauDeParentesco) {
		this.grauDeParentesco = grauDeParentesco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public StatusRelacaoEnum getStatusRelacao() {
		return statusRelacao;
	}

	public void setStatusRelacao(StatusRelacaoEnum statusRelacao) {
		this.statusRelacao = statusRelacao;
	}

	public LocalDate getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(LocalDate dataEvento) {
		this.dataEvento = dataEvento;
	}

	public Familia getFamilia() {
		return familia;
	}

	public void setFamilia(Familia familia) {
		this.familia = familia;
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
