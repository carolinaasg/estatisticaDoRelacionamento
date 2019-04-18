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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.com.vtrhp.estatistica.api.enums.NacionalidadeEnum;
import br.com.vtrhp.estatistica.api.enums.OrientacaoSexualEnum;
import br.com.vtrhp.estatistica.api.enums.PaisesEnum;
import br.com.vtrhp.estatistica.api.enums.SignosEnum;

@Entity
public class Amigos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2028297871956417466L;

	@Id
	private Long idAmigo;
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
	private Integer tamanhoPe;

	@ManyToOne(fetch = FetchType.EAGER)
	private Pessoa pessoa;

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

	// Manutenção da Tabela
	private LocalDate dataCriacao;
	private LocalDate dataAtualizacao;

	public Long getIdAmigo() {
		return idAmigo;
	}

	public void setIdAmigo(Long idAmigo) {
		this.idAmigo = idAmigo;
	}

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

	public Integer getTamanhoPe() {
		return tamanhoPe;
	}

	public void setTamanhoPe(Integer tamanhoPe) {
		this.tamanhoPe = tamanhoPe;
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

}