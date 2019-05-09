package br.com.vtrhp.estatistica.api.dtos;

public class FamiliaDTO {
	private Long idFamilia;
	private String nome;
	private String dataNascimento;
	private String horaNascimento;
	private Double altura;
	private Double peso;
	private String corOlhos;
	private String corCabelo;
	private String tipoSanguineo;
	private String estadoNascimento;
	private String cidadeNascimento;
	private String orientacaoSexual;
	private String paisOrigem;
	private String nacionalidade;
	private String adotivo;
	private String signo;
	private String sexo;
	private String descendencia;
	private Integer tamanhoPe;
	private String grauParentesco;

	public Long getIdFamilia() {
		return idFamilia;
	}

	public void setIdFamilia(Long idFamilia) {
		this.idFamilia = idFamilia;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getHoraNascimento() {
		return horaNascimento;
	}

	public void setHoraNascimento(String horaNascimento) {
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

	public String getPaisOrigem() {
		return paisOrigem;
	}

	public void setPaisOrigem(String paisOrigem) {
		this.paisOrigem = paisOrigem;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getAdotivo() {
		return adotivo;
	}

	public void setAdotivo(String adotivo) {
		this.adotivo = adotivo;
	}

	public String getSigno() {
		return signo;
	}

	public void setSigno(String signo) {
		this.signo = signo;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
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

	public String getGrauParentesco() {
		return grauParentesco;
	}

	public void setGrauParentesco(String grauParentesco) {
		this.grauParentesco = grauParentesco;
	}

	@Override
	public String toString() {
		return "FamiliaDTO [idFamilia=" + idFamilia + ", nome=" + nome + ", dataNascimento=" + dataNascimento
				+ ", horaNascimento=" + horaNascimento + ", altura=" + altura + ", peso=" + peso + ", estadoNascimento="
				+ estadoNascimento + ", cidadeNascimento=" + cidadeNascimento + ", orientacaoSexual=" + orientacaoSexual
				+ ", paisOrigem=" + paisOrigem + ", nacionalidade=" + nacionalidade + ", adotivo=" + adotivo
				+ ", signo=" + signo + ", descendencia=" + descendencia + ", tamanhoPe=" + tamanhoPe
				+ ", grauParentesco=" + grauParentesco + "]";
	}

}
