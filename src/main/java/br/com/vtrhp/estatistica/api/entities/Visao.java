package br.com.vtrhp.estatistica.api.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import br.com.vtrhp.estatistica.api.enums.ProblemasVisao;

@Entity
public class Visao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5501459470347058476L;
	@Id
	private Long idVisao;
	private Double grauOlhoEsquerdo;
	private Double grauOlhoDireito;
	@Enumerated(EnumType.STRING)
	private ProblemasVisao tipoGrauOlhoEsquerdo;
	@Enumerated(EnumType.STRING)
	private ProblemasVisao tipoGrauOlhoDireito;

	private String usaOCulos;
	private String fezCirurgia;
	private String usaLenteContato;

	private LocalDate dataCriacao;
	private LocalDate dataAtualizacao;

	public Long getIdVisao() {
		return idVisao;
	}

	public void setIdVisao(Long idVisao) {
		this.idVisao = idVisao;
	}

	public Double getGrauOlhoEsquerdo() {
		return grauOlhoEsquerdo;
	}

	public void setGrauOlhoEsquerdo(Double grauOlhoEsquerdo) {
		this.grauOlhoEsquerdo = grauOlhoEsquerdo;
	}

	public Double getGrauOlhoDireito() {
		return grauOlhoDireito;
	}

	public void setGrauOlhoDireito(Double grauOlhoDireito) {
		this.grauOlhoDireito = grauOlhoDireito;
	}

	public ProblemasVisao getTipoGrauOlhoEsquerdo() {
		return tipoGrauOlhoEsquerdo;
	}

	public void setTipoGrauOlhoEsquerdo(ProblemasVisao tipoGrauOlhoEsquerdo) {
		this.tipoGrauOlhoEsquerdo = tipoGrauOlhoEsquerdo;
	}

	public ProblemasVisao getTipoGrauOlhoDireito() {
		return tipoGrauOlhoDireito;
	}

	public void setTipoGrauOlhoDireito(ProblemasVisao tipoGrauOlhoDireito) {
		this.tipoGrauOlhoDireito = tipoGrauOlhoDireito;
	}

	public String getUsaOCulos() {
		return usaOCulos;
	}

	public void setUsaOCulos(String usaOCulos) {
		this.usaOCulos = usaOCulos;
	}

	public String getFezCirurgia() {
		return fezCirurgia;
	}

	public void setFezCirurgia(String fezCirurgia) {
		this.fezCirurgia = fezCirurgia;
	}

	public String getUsaLenteContato() {
		return usaLenteContato;
	}

	public void setUsaLenteContato(String usaLenteContato) {
		this.usaLenteContato = usaLenteContato;
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
