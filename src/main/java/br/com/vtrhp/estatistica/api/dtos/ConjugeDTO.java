package br.com.vtrhp.estatistica.api.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

public class ConjugeDTO {

	private Long idConjuge;
	private String nome;
	private String sobreNome;
	private Double altura;
	private Double peso;
	private String corOlhos;
	private String corCabelo;
	private String tipoSanguineo;
	private String sexo;
	private LocalDate dataNascimento;
	private LocalTime horaNascimento;
	private String estadoNascimento;
	private String cidadeNascimento;
	private String orientacaoSexual;
	private String paisDeOrigem;
	private String nacionalidade;
	private char adotivo;
	private String signo;
	private String descendencia;
	private Integer tamanhoPe;

	public ConjugeDTO() {
	}

	public Long getIdConjuge() {
		return idConjuge;
	}

	public void setIdConjuge(Long idConjuge) {
		this.idConjuge = idConjuge;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
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

	public String getOrientacaoSexual() {
		return orientacaoSexual;
	}

	public void setOrientacaoSexual(String orientacaoSexual) {
		this.orientacaoSexual = orientacaoSexual;
	}

	public String getPaisDeOrigem() {
		return paisDeOrigem;
	}

	public void setPaisDeOrigem(String paisDeOrigem) {
		this.paisDeOrigem = paisDeOrigem;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public char getAdotivo() {
		return adotivo;
	}

	public void setAdotivo(char adotivo) {
		this.adotivo = adotivo;
	}

	public String getSigno() {
		return signo;
	}

	public void setSigno(String signo) {
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

	@Override
	public String toString() {
		return "ConjugeDTO [idConjuge=" + idConjuge + ", nome=" + nome + ", sobreNome=" + sobreNome + ", altura="
				+ altura + ", peso=" + peso + ", corOlhos=" + corOlhos + ", corCabelo=" + corCabelo + ", tipoSanguineo="
				+ tipoSanguineo + ", sexo=" + sexo + ", dataNascimento=" + dataNascimento + ", horaNascimento="
				+ horaNascimento + ", estadoNascimento=" + estadoNascimento + ", cidadeNascimento=" + cidadeNascimento
				+ ", orientacaoSexual=" + orientacaoSexual + ", paisDeOrigem=" + paisDeOrigem + ", nacionalidade="
				+ nacionalidade + ", adotivo=" + adotivo + ", signo=" + signo + ", descendencia=" + descendencia
				+ ", tamanhoPe=" + tamanhoPe + "]";
	}

}
