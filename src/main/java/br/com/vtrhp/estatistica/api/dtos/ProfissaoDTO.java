package br.com.vtrhp.estatistica.api.dtos;

import java.math.BigDecimal;

public class ProfissaoDTO {

	private Long idProfissao;
	private String nomeEmpresa;
	private String profissao;
	private String cargo;
	private String descricao;
	private BigDecimal salarioBruto;
	private BigDecimal salarioLiquido;
	private Integer qtdSubordinados;

	public Long getIdProfissao() {
		return idProfissao;
	}

	public void setIdProfissao(Long idProfissao) {
		this.idProfissao = idProfissao;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getSalarioBruto() {
		return salarioBruto;
	}

	public void setSalarioBruto(BigDecimal salarioBruto) {
		this.salarioBruto = salarioBruto;
	}

	public BigDecimal getSalarioLiquido() {
		return salarioLiquido;
	}

	public void setSalarioLiquido(BigDecimal salarioLiquido) {
		this.salarioLiquido = salarioLiquido;
	}

	public Integer getQtdSubordinados() {
		return qtdSubordinados;
	}

	public void setQtdSubordinados(Integer qtdSubordinados) {
		this.qtdSubordinados = qtdSubordinados;
	}

}
