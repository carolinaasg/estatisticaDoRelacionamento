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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import br.com.vtrhp.estatistica.api.enums.NacionalidadeEnum;
import br.com.vtrhp.estatistica.api.enums.OrientacaoSexualEnum;
import br.com.vtrhp.estatistica.api.enums.PaisesEnum;
import br.com.vtrhp.estatistica.api.enums.SignosEnum;

@Entity
public class Familia implements Serializable{	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4217903259530478432L;
	@Id
	private Long idFamilia;	
	private Long idPessoa;
	private Long idRelacaoFamilia;
	private String nome;	
	private LocalDate dataNascimento;	
	private LocalTime horaNascimento;	
	private Double altura;	
	private Double peso;	
	private String estadoNascimento;	
	private String cidadeNascimento;
	private char adotivo;
	private LocalDate dataFalecimento;
	private LocalTime horaFalecimento;

	
	@Enumerated(EnumType.STRING)	
	private OrientacaoSexualEnum orientacaoSexual;
	@Enumerated(EnumType.STRING)	
	private PaisesEnum paisDeOrigem;
	@Enumerated(EnumType.STRING)	
	private NacionalidadeEnum nacionalidade;	
	@Enumerated(EnumType.STRING)	
	private SignosEnum signo;
	
	private String descendencia;
	private Integer tamanhoPe;
	private String grauDeParentesco;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Pessoa pessoa;

	@OneToMany(mappedBy = "familia", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<RelacaoComFamilia> relacaoComFamilia;
	
	@OneToMany(mappedBy = "familia", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<PontosPositivosFamilia> pontosPositivosFamilia;
	@OneToMany(mappedBy = "familia", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<PontosNegativosFamilia> pontosNegativosFamilia;
	@OneToMany(mappedBy = "familia", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ContatoComFamilia> contatoComFamilia;


	// Manutenção da Tabela	
	private LocalDate dataCriacao;	
	private LocalDate dataAtualizacao;
	
	public Long getIdFamilia() {
		return idFamilia;
	}

	public void setIdFamilia(Long idFamilia) {
		this.idFamilia = idFamilia;
	}

	public Long getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}

	public Long getIdRelacaoFamilia() {
		return idRelacaoFamilia;
	}

	public void setIdRelacaoFamilia(Long idRelacaoFamilia) {
		this.idRelacaoFamilia = idRelacaoFamilia;
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

	public char getAdotivo() {
		return adotivo;
	}

	public void setAdotivo(char adotivo) {
		this.adotivo = adotivo;
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

	public String getGrauDeParentesco() {
		return grauDeParentesco;
	}

	public void setGrauDeParentesco(String grauDeParentesco) {
		this.grauDeParentesco = grauDeParentesco;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<RelacaoComFamilia> getRelacaoComFamilia() {
		return relacaoComFamilia;
	}

	public void setRelacaoComFamilia(List<RelacaoComFamilia> relacaoComFamilia) {
		this.relacaoComFamilia = relacaoComFamilia;
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

	public LocalDate getDataFalecimento() {
		return dataFalecimento;
	}

	public void setDataFalecimento(LocalDate dataFalecimento) {
		this.dataFalecimento = dataFalecimento;
	}

	public LocalTime getHoraFalecimento() {
		return horaFalecimento;
	}

	public void setHoraFalecimento(LocalTime horaFalecimento) {
		this.horaFalecimento = horaFalecimento;
	}

	public List<PontosPositivosFamilia> getPontosPositivosFamilia() {
		return pontosPositivosFamilia;
	}

	public void setPontosPositivosFamilia(List<PontosPositivosFamilia> pontosPositivosFamilia) {
		this.pontosPositivosFamilia = pontosPositivosFamilia;
	}

	public List<PontosNegativosFamilia> getPontosNegativosFamilia() {
		return pontosNegativosFamilia;
	}

	public void setPontosNegativosFamilia(List<PontosNegativosFamilia> pontosNegativosFamilia) {
		this.pontosNegativosFamilia = pontosNegativosFamilia;
	}

	public List<ContatoComFamilia> getContatoComFamilia() {
		return contatoComFamilia;
	}

	public void setContatoComFamilia(List<ContatoComFamilia> contatoComFamilia) {
		this.contatoComFamilia = contatoComFamilia;
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
