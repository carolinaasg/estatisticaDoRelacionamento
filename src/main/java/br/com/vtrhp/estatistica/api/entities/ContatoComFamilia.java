package br.com.vtrhp.estatistica.api.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import br.com.vtrhp.estatistica.api.enums.PaisesEnum;

@Entity
public class ContatoComFamilia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4811141967100388854L;

	@Id
	private Long idContatoComFamilia;
	private Long idFamilia;
	private LocalDate data;
	private String virtual;
	private String pessoalmente;
	private String descricao;
	private PaisesEnum pais;
	private String estado;
	private String cidade;
	private String local;
	private String motivo;
	private LocalTime qtdHorasJuntos;

	@ManyToOne(fetch = FetchType.EAGER)
	private Familia familia;

	// Manutenção da Tabela
	private LocalDate dataCriacao;
	private LocalDate dataAtualizacao;

	public Long getIdContatoComFamilia() {
		return idContatoComFamilia;
	}

	public void setIdContatoComFamilia(Long idContatoComFamilia) {
		this.idContatoComFamilia = idContatoComFamilia;
	}

	public Long getIdFamilia() {
		return idFamilia;
	}

	public void setIdFamilia(Long idFamilia) {
		this.idFamilia = idFamilia;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getVirtual() {
		return virtual;
	}

	public void setVirtual(String virtual) {
		this.virtual = virtual;
	}

	public String getPessoalmente() {
		return pessoalmente;
	}

	public void setPessoalmente(String pessoalmente) {
		this.pessoalmente = pessoalmente;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public LocalTime getQtdHorasJuntos() {
		return qtdHorasJuntos;
	}

	public void setQtdHorasJuntos(LocalTime qtdHorasJuntos) {
		this.qtdHorasJuntos = qtdHorasJuntos;
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
