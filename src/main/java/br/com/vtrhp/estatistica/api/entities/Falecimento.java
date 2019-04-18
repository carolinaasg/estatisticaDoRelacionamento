package br.com.vtrhp.estatistica.api.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Entity
public class Falecimento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4786303003947185271L;

	@Id
	private Long idFalecimento;
	private Long idPessoa;
	private Long idFamilia;
	private Long idAmigo;
	private String motivo;
	private LocalDate data;
	private LocalTime hora;
	private String descricao;

	@OneToOne(fetch = FetchType.EAGER)
	private Pessoa pessoa;

	@OneToOne(fetch = FetchType.EAGER)
	private Familia familia;
	
	@OneToOne(fetch = FetchType.EAGER)
	private Amigos amigo;

	// Manutenção da Tabela
	private LocalDate dataCriacao;
	private LocalDate dataAtualizacao;

	public Long getIdFalecimento() {
		return idFalecimento;
	}

	public void setIdFalecimento(Long idFalecimento) {
		this.idFalecimento = idFalecimento;
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

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
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

	public Long getIdAmigo() {
		return idAmigo;
	}

	public void setIdAmigo(Long idAmigo) {
		this.idAmigo = idAmigo;
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
