package br.com.vtrhp.estatistica.api.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import br.com.vtrhp.estatistica.api.enums.NacionalidadeEnum;
import br.com.vtrhp.estatistica.api.enums.OrientacaoSexualEnum;
import br.com.vtrhp.estatistica.api.enums.PaisesEnum;
import br.com.vtrhp.estatistica.api.enums.SignosEnum;

@Entity
public class Pessoa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3962008930812602687L;

	@Id	
	private Long idPessoa;	
	private String nome;	
	private LocalDate dataNascimento;	
	private LocalTime horaNascimento;	
	private Double altura;	
	private Double peso;	
	private String estadoNascimento;	
	private String cidadeNascimento;
	@Enumerated(EnumType.STRING)	
	private OrientacaoSexualEnum orientacaoSexual;
	@Enumerated(EnumType.STRING)	
	private PaisesEnum paisDeOrigem;
	@Enumerated(EnumType.STRING)	
	private NacionalidadeEnum nacionalidade;	
	private char adotivo;
	@Enumerated(EnumType.STRING)	
	private SignosEnum signo;	
	private String descendencia;

	@OneToOne(mappedBy = "pessoa", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<OndeConheci> ondeConheci;

	// LISTAS
	@OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<AssuntosDeInteresse> assuntosDeInteresse;

	@OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Residencia> residencia;

	// Manutenção da Tabela	
	private LocalDate dataCriacao;	
	private LocalDate dataAtualizacao;

	public Long getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public LocalTime getHoraNascimento() {
		return horaNascimento;
	}

	public void setHoraNascimento(LocalTime horaNascimento) {
		this.horaNascimento = horaNascimento;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public String getEstadoNascimento() {
		return estadoNascimento;
	}

	public void setEstadoNascimento(String estadoNascimento) {
		this.estadoNascimento = estadoNascimento;
	}

	public String getCidadeNascimento() {
		return cidadeNascimento;
	}

	public void setCidadeNascimento(String cidadeNascimento) {
		this.cidadeNascimento = cidadeNascimento;
	}

	public OrientacaoSexualEnum getOrientacaoSexual() {
		return orientacaoSexual;
	}

	public void setOrientacaoSexual(OrientacaoSexualEnum orientacaoSexual) {
		this.orientacaoSexual = orientacaoSexual;
	}

	public PaisesEnum getPaisDeOrigem() {
		return paisDeOrigem;
	}

	public void setPaisDeOrigem(PaisesEnum paisDeOrigem) {
		this.paisDeOrigem = paisDeOrigem;
	}

	public NacionalidadeEnum getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(NacionalidadeEnum nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public char getAdotivo() {
		return adotivo;
	}

	public void setAdotivo(char adotivo) {
		this.adotivo = adotivo;
	}

	public SignosEnum getSigno() {
		return signo;
	}

	public void setSigno(SignosEnum signo) {
		this.signo = signo;
	}

	public String getDescendencia() {
		return descendencia;
	}

	public void setDescendencia(String descendencia) {
		this.descendencia = descendencia;
	}

	public List<OndeConheci> getOndeConheci() {
		return ondeConheci;
	}

	public void setOndeConheci(List<OndeConheci> ondeConheci) {
		this.ondeConheci = ondeConheci;
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
