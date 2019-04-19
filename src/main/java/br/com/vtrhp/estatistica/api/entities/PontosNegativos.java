package br.com.vtrhp.estatistica.api.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Entity
public class PontosNegativos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3716021588140172701L;

	@Id
	private Long idPontosNegativos;
	private String pontosNegativos;
	private LocalDate data;
	private String motivo;

	// Manutenção da Tabela
	private LocalDate dataCriacao;
	private LocalDate dataAtualizacao;

	public Long getIdPontosNegativos() {
		return idPontosNegativos;
	}

	public void setIdPontosNegativos(Long idPontosNegativos) {
		this.idPontosNegativos = idPontosNegativos;
	}

	public String getPontosNegativosFamilia() {
		return pontosNegativos;
	}

	public void setPontosNegativos(String pontosNegativos) {
		this.pontosNegativos = pontosNegativos;
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
