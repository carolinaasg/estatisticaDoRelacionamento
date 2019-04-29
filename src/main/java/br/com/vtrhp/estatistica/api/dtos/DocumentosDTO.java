package br.com.vtrhp.estatistica.api.dtos;

import org.hibernate.validator.constraints.br.CPF;

public class DocumentosDTO {

	private Long idDocumentos;
	private String rg;
	@CPF(message = "CPF inválido")
	private String cpf;
	private String habilitacao;

	public DocumentosDTO() {

	}

	public Long getIdDocumentos() {
		return idDocumentos;
	}

	public void setIdDocumentos(Long idDocumentos) {
		this.idDocumentos = idDocumentos;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getHabilitacao() {
		return habilitacao;
	}

	public void setHabilitacao(String habilitacao) {
		this.habilitacao = habilitacao;
	}

	@Override
	public String toString() {
		return "DocumentosDTO [idDocumentos=" + idDocumentos + ", rg=" + rg + ", cpf="
				+ cpf + ", habilitacao=" + habilitacao + "]";
	}

}
