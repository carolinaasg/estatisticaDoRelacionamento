package br.com.vtrhp.estatistica.api.dtos;

public class VeiculoDTO {

	private Long idVeiculo;
	private String placa;
	private String renavam;
	private String qtPortas;
	private String motor;
	private String dataCompra;
	private String dataVenda;
	private String tipo;
	private String marca;
	private String modelo;
	private Integer anoFabricacao;
	private Integer anoModelo;
	private Integer quilometragem;

	public Long getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(Long idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getRenavam() {
		return renavam;
	}

	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}

	public String getQtPortas() {
		return qtPortas;
	}

	public void setQtPortas(String qtPortas) {
		this.qtPortas = qtPortas;
	}

	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	public String getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(String dataCompra) {
		this.dataCompra = dataCompra;
	}

	public String getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(String dataVenda) {
		this.dataVenda = dataVenda;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(Integer anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public Integer getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(Integer anoModelo) {
		this.anoModelo = anoModelo;
	}

	public Integer getQuilometragem() {
		return quilometragem;
	}

	public void setQuilometragem(Integer quilometragem) {
		this.quilometragem = quilometragem;
	}

	@Override
	public String toString() {
		return "VeiculoDTO [idVeiculo=" + idVeiculo + ", placa=" + placa + ", renavam=" + renavam + ", qtPortas="
				+ qtPortas + ", motor=" + motor + ", dataCompra=" + dataCompra + ", dataVenda=" + dataVenda + ", tipo="
				+ tipo + ", marca=" + marca + ", modelo=" + modelo + ", anoFabricacao=" + anoFabricacao + ", anoModelo="
				+ anoModelo + ", quilometragem=" + quilometragem + "]";
	}

}
