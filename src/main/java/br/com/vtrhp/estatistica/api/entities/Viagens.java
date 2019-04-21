package br.com.vtrhp.estatistica.api.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import br.com.vtrhp.estatistica.api.enums.PaisesEnum;

@Entity
public class Viagens implements Serializable {

	private static final long serialVersionUID = 6251765667507168242L;
	@Id
	private Long idViagem;
	private PaisesEnum pais;
	private String estado;
	private String cidade;
	private LocalDate data;
	private String descricao;
	private String motivo;

	public Long getIdViagem() {
		return idViagem;
	}

	public void setIdViagem(Long idViagem) {
		this.idViagem = idViagem;
	}

	public PaisesEnum getPais() {
		return pais;
	}

	public void setPais(PaisesEnum pais) {
		this.pais = pais;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

}
