package br.com.vtrhp.estatistica.api.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import br.com.vtrhp.estatistica.api.enums.PaisesEnum;

@Entity
@Table(name = "residencia")
public class Residencia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1100325593268914306L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String endereco;
	private Integer numero;
	private String complemento;
	private String cep;
	private String bairro;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "pais")
	private PaisesEnum pais;
	
	private String qtoTempoMora;
	private String moraCom;
	private String relacionamentoComVizinhos;
	private LocalDate dataCriacao;
	private LocalDate dataAtualizacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public PaisesEnum getPais() {
		return pais;
	}

	public void setPais(PaisesEnum pais) {
		this.pais = pais;
	}

	public String getQtoTempoMora() {
		return qtoTempoMora;
	}

	public void setQtoTempoMora(String qtoTempoMora) {
		this.qtoTempoMora = qtoTempoMora;
	}

	public String getMoraCom() {
		return moraCom;
	}

	public void setMoraCom(String moraCom) {
		this.moraCom = moraCom;
	}

	public String getRelacionamentoComVizinhos() {
		return relacionamentoComVizinhos;
	}

	public void setRelacionamentoComVizinhos(String relacionamentoComVizinhos) {
		this.relacionamentoComVizinhos = relacionamentoComVizinhos;
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
		dataCriacao = atual;
		dataAtualizacao = atual;
	}
	

}
