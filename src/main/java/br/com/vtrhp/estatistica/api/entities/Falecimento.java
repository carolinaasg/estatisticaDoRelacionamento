package br.com.vtrhp.estatistica.api.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.Id;

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

	public Long getIdAmigo() {
		return idAmigo;
	}

	public void setIdAmigo(Long idAmigo) {
		this.idAmigo = idAmigo;
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



}
