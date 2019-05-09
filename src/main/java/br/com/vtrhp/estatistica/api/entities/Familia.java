package br.com.vtrhp.estatistica.api.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import br.com.vtrhp.estatistica.api.enums.NacionalidadeEnum;
import br.com.vtrhp.estatistica.api.enums.OrientacaoSexualEnum;
import br.com.vtrhp.estatistica.api.enums.PaisesEnum;
import br.com.vtrhp.estatistica.api.enums.SexoEnum;
import br.com.vtrhp.estatistica.api.enums.SignosEnum;

@Entity
@Table(name = "familia")
public class Familia implements Serializable {

	private static final long serialVersionUID = 5001128121913718140L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idFamilia;
	private String nome;
	private LocalDate dataNascimento;
	private LocalTime horaNascimento;
	private Double altura;
	private Double peso;
	private String corOlhos;
	private String corCabelo;
	private String tipoSanguineo;	
	private String estadoNascimento;
	private String cidadeNascimento;
	@Enumerated(EnumType.STRING)
	private OrientacaoSexualEnum orientacaoSexual;
	@Enumerated(EnumType.STRING)
	private PaisesEnum paisOrigem;
	@Enumerated(EnumType.STRING)
	private NacionalidadeEnum nacionalidade;
	private String adotivo;
	@Enumerated(EnumType.STRING)
	private SignosEnum signo;
	@Enumerated(EnumType.STRING)
	private SexoEnum sexo;
	private String descendencia;
	private Integer tamanhoPe;
	private String grauParentesco;
	private LocalDate dataCriacao;
	private LocalDate dataAtualizacao;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_conjuge", nullable = false)
	private Conjuge conjuge;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_usuario", nullable = false)
	private Usuario usuario;
	
	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade =	CascadeType.ALL) 
	private List<Profissao> profissao;

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

	@Column(name = "id_familia")
	public Long getIdFamilia() {
		return idFamilia;
	}

	public void setIdFamilia(Long idFamilia) {
		this.idFamilia = idFamilia;
	}

	@Column(name = "nome")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "data_nascimento")
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Column(name = "hora_nascimento")
	public LocalTime getHoraNascimento() {
		return horaNascimento;
	}

	public void setHoraNascimento(LocalTime horaNascimento) {
		this.horaNascimento = horaNascimento;
	}

	@Column(name = "altura")
	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	@Column(name = "peso")
	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public String getCorOlhos() {
		return corOlhos;
	}

	public void setCorOlhos(String corOlhos) {
		this.corOlhos = corOlhos;
	}

	public String getCorCabelo() {
		return corCabelo;
	}

	public void setCorCabelo(String corCabelo) {
		this.corCabelo = corCabelo;
	}

	public String getTipoSanguineo() {
		return tipoSanguineo;
	}

	public void setTipoSanguineo(String tipoSanguineo) {
		this.tipoSanguineo = tipoSanguineo;
	}

	@Column(name = "estado_nascimento")
	public String getEstadoNascimento() {
		return estadoNascimento;
	}

	public void setEstadoNascimento(String estadoNascimento) {
		this.estadoNascimento = estadoNascimento;
	}

	@Column(name = "cidade_nascimento")
	public String getCidadeNascimento() {
		return cidadeNascimento;
	}

	public void setCidadeNascimento(String cidadeNascimento) {
		this.cidadeNascimento = cidadeNascimento;
	}

	@Column(name = "orientacao_sexual")
	public OrientacaoSexualEnum getOrientacaoSexual() {
		return orientacaoSexual;
	}

	public void setOrientacaoSexual(OrientacaoSexualEnum orientacaoSexual) {
		this.orientacaoSexual = orientacaoSexual;
	}

	@Column(name = "pais_origem")
	public PaisesEnum getPaisOrigem() {
		return paisOrigem;
	}

	public void setPaisOrigem(PaisesEnum paisOrigem) {
		this.paisOrigem = paisOrigem;
	}

	@Column(name = "nacionalidade")
	public NacionalidadeEnum getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(NacionalidadeEnum nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	@Column(name = "adotivo")
	public String getAdotivo() {
		return adotivo;
	}

	public void setAdotivo(String adotivo) {
		this.adotivo = adotivo;
	}

	@Column(name = "signo")
	public SignosEnum getSigno() {
		return signo;
	}

	public void setSigno(SignosEnum signo) {
		this.signo = signo;
	}

	public SexoEnum getSexo() {
		return sexo;
	}

	public void setSexo(SexoEnum sexo) {
		this.sexo = sexo;
	}

	@Column(name = "descendencia")
	public String getDescendencia() {
		return descendencia;
	}

	public void setDescendencia(String descendencia) {
		this.descendencia = descendencia;
	}

	@Column(name = "tamanho_pe")
	public Integer getTamanhoPe() {
		return tamanhoPe;
	}

	public void setTamanhoPe(Integer tamanhoPe) {
		this.tamanhoPe = tamanhoPe;
	}

	@Column(name = "grau_parentesco")
	public String getGrauParentesco() {
		return grauParentesco;
	}

	public void setGrauParentesco(String grauParentesco) {
		this.grauParentesco = grauParentesco;
	}

	@Column(name = "data_criacao")
	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@Column(name = "data_atualizacao")
	public LocalDate getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDate dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public Conjuge getConjuge() {
		return conjuge;
	}

	public void setConjuge(Conjuge conjuge) {
		this.conjuge = conjuge;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
