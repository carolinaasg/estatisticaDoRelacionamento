package br.com.vtrhp.estatistica.api.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import br.com.vtrhp.estatistica.api.enums.AplicativosDeRelacionamentoEnum;

@Entity
public class OndeConheci implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3180265044652498331L;

	@Id	
	private Long idOndeConheci;
	private Long idPessoa;
	private Long idAmigo;
	private AplicativosDeRelacionamentoEnum app;
	private String nomeLocal;
	private String tipo;
	private String descricao;
	private String cidade;
	private String Estado;
	private LocalDate data;
	private LocalTime hora;
	


	private LocalDate dataCriacao;
	private LocalDate dataAtualizacao;

	public Long getIdOndeConheci() {
		return idOndeConheci;
	}

	public void setIdOndeConheci(Long idOndeConheci) {
		this.idOndeConheci = idOndeConheci;
	}

	public AplicativosDeRelacionamentoEnum getApp() {
		return app;
	}

	public void setApp(AplicativosDeRelacionamentoEnum app) {
		this.app = app;
	}

	public String getNomeLocal() {
		return nomeLocal;
	}

	public void setNomeLocal(String nomeLocal) {
		this.nomeLocal = nomeLocal;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
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



	public Long getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}

	public Long getIdAmigo() {
		return idAmigo;
	}

	public void setIdAmigo(Long idAmigo) {
		this.idAmigo = idAmigo;
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
