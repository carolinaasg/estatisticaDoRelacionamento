package br.com.vtrhp.estatistica.api.dtos;

public class VisaoDTO {

	private Long idVisao;
	private Double grauEsquerdo;
	private Double grauDireito;
	private String tipoEsquerdo;
	private String tipoDireito;
	private String usaOculos;
	private String fezCirurgia;
	private String usaLente;

	public Long getIdVisao() {
		return idVisao;
	}

	public void setIdVisao(Long idVisao) {
		this.idVisao = idVisao;
	}

	public Double getGrauEsquerdo() {
		return grauEsquerdo;
	}

	public void setGrauEsquerdo(Double grauEsquerdo) {
		this.grauEsquerdo = grauEsquerdo;
	}

	public Double getGrauDireito() {
		return grauDireito;
	}

	public void setGrauDireito(Double grauDireito) {
		this.grauDireito = grauDireito;
	}

	public String getTipoEsquerdo() {
		return tipoEsquerdo;
	}

	public void setTipoEsquerdo(String tipoEsquerdo) {
		this.tipoEsquerdo = tipoEsquerdo;
	}

	public String getTipoDireito() {
		return tipoDireito;
	}

	public void setTipoDireito(String tipoDireito) {
		this.tipoDireito = tipoDireito;
	}

	public String getUsaOculos() {
		return usaOculos;
	}

	public void setUsaOculos(String usaOculos) {
		this.usaOculos = usaOculos;
	}

	public String getFezCirurgia() {
		return fezCirurgia;
	}

	public void setFezCirurgia(String fezCirurgia) {
		this.fezCirurgia = fezCirurgia;
	}

	public String getUsaLente() {
		return usaLente;
	}

	public void setUsaLente(String usaLente) {
		this.usaLente = usaLente;
	}

	@Override
	public String toString() {
		return "VisaoDTO [idVisao=" + idVisao + ", grauEsquerdo=" + grauEsquerdo + ", grauDireito=" + grauDireito
				+ ", tipoEsquerdo=" + tipoEsquerdo + ", tipoDireito=" + tipoDireito
				+ ", usaOculos=" + usaOculos + ", fezCirurgia=" + fezCirurgia + ", usaLente=" + usaLente + "]";
	}
	
	

}
