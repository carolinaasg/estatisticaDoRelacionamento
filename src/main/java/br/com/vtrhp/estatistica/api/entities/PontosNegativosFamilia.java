package br.com.vtrhp.estatistica.api.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Entity
public class PontosNegativosFamilia implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3716021588140172701L;
	
	@Id
	private Long idPontosNegativosFamilia;
	private Long idFamilia;
	private String pontosNegativosFamilia;
	private LocalDate data;
	private String motivo;		
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Familia familia;
	// Manutenção da Tabela	
	private LocalDate dataCriacao;	
	private LocalDate dataAtualizacao;
	
	public Long getIdPontosNegativosFamilia() {
		return idPontosNegativosFamilia;
	}
	public void setIdPontosNegativosFamilia(Long idPontosNegativosFamilia) {
		this.idPontosNegativosFamilia = idPontosNegativosFamilia;
	}
	public Long getIdFamilia() {
		return idFamilia;
	}
	public void setIdFamilia(Long idFamilia) {
		this.idFamilia = idFamilia;
	}
	public String getPontosNegativosFamilia() {
		return pontosNegativosFamilia;
	}
	public void setPontosNegativosFamilia(String pontosNegativosFamilia) {
		this.pontosNegativosFamilia = pontosNegativosFamilia;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
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
