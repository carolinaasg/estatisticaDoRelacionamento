package br.com.vtrhp.estatistica.api.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Entity
public class Amigos implements Serializable {

	private static final long serialVersionUID = -2028297871956417466L;
	
	private Long IdAmigo;
	
	private Pessoa pessoa;
	
	// Manutenção da Tabela
	private LocalDate dataCriacao;
	private LocalDate dataAtualizacao;
	

	@OneToOne(mappedBy = "amigos", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private OndeConheci ondeConheci;

	@OneToOne(mappedBy = "amigos", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Falecimento falecimento;

	// LISTAS
	@OneToMany(mappedBy = "amigos", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<AssuntosDeInteresse> assuntosDeInteresse;

	@OneToMany(mappedBy = "amigos", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Residencia> residencia;

	@OneToMany(mappedBy = "amigos", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Profissao> profissao;

	@OneToMany(mappedBy = "amigos", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Veiculo> veiculo;
	
	@OneToMany(mappedBy = "amigos", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Deficiencia deficiencia;


	public Long getIdAmigo() {
		return IdAmigo;
	}

	public void setIdAmigo(Long idAmigo) {
		IdAmigo = idAmigo;
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

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public OndeConheci getOndeConheci() {
		return ondeConheci;
	}

	public void setOndeConheci(OndeConheci ondeConheci) {
		this.ondeConheci = ondeConheci;
	}

	public Falecimento getFalecimento() {
		return falecimento;
	}

	public void setFalecimento(Falecimento falecimento) {
		this.falecimento = falecimento;
	}

	public List<AssuntosDeInteresse> getAssuntosDeInteresse() {
		return assuntosDeInteresse;
	}

	public void setAssuntosDeInteresse(List<AssuntosDeInteresse> assuntosDeInteresse) {
		this.assuntosDeInteresse = assuntosDeInteresse;
	}

	public List<Residencia> getResidencia() {
		return residencia;
	}

	public void setResidencia(List<Residencia> residencia) {
		this.residencia = residencia;
	}

	public List<Profissao> getProfissao() {
		return profissao;
	}

	public void setProfissao(List<Profissao> profissao) {
		this.profissao = profissao;
	}

	public List<Veiculo> getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(List<Veiculo> veiculo) {
		this.veiculo = veiculo;
	}

	public Deficiencia getDeficiencia() {
		return deficiencia;
	}

	public void setDeficiencia(Deficiencia deficiencia) {
		this.deficiencia = deficiencia;
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
