package br.com.vtrhp.estatistica.api.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "profissao")
public class Profissao implements Serializable {

	private static final long serialVersionUID = -4452861555374092394L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idProfissao;
	private String nomeEmpresa;
	private String profissao;
	private String cargo;
	private String Descricao;
	private BigDecimal salarioBruto;
	private BigDecimal salarioLiquido;
	private Integer qtdSubordinados;
	private LocalDate dataDemissao;
	private LocalDate dataContratacao;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_conjuge")
	private Conjuge conjuge;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_amigo")
	private Amigos amigos;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_familia")
	private Familia familia;

	private LocalDate dataCriacao;
	private LocalDate dataAtualizacao;

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

	public Amigos getAmigos() {
		return amigos;
	}

	public void setAmigos(Amigos amigos) {
		this.amigos = amigos;
	}

	public Familia getFamilia() {
		return familia;
	}

	public void setFamilia(Familia familia) {
		this.familia = familia;
	}
	@Column(name = "id_profissao")
	public Long getIdProfissao() {
		return idProfissao;
	}

	public void setIdProfissao(Long idProfissao) {
		this.idProfissao = idProfissao;
	}
	@Column(name = "nome_empresa")
	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}
	@Column(name = "profissao")
	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	@Column(name = "cargo")
	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	@Column(name = "descricao")
	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
	@Column(name = "salario_bruto")
	public BigDecimal getSalarioBruto() {
		return salarioBruto;
	}

	public void setSalarioBruto(BigDecimal salarioBruto) {
		this.salarioBruto = salarioBruto;
	}
	@Column(name = "salario_liquido")
	public BigDecimal getSalarioLiquido() {
		return salarioLiquido;
	}

	public void setSalarioLiquido(BigDecimal salarioLiquido) {
		this.salarioLiquido = salarioLiquido;
	}
	@Column(name = "qtd_subordinados")
	public Integer getQtdSubordinados() {
		return qtdSubordinados;
	}

	public void setQtdSubordinados(Integer qtdSubordinados) {
		this.qtdSubordinados = qtdSubordinados;
	}
	@Column(name = "data_demissao")
	public LocalDate getDataDemissao() {
		return dataDemissao;
	}

	public void setDataDemissao(LocalDate dataDemissao) {
		this.dataDemissao = dataDemissao;
	}
	@Column(name = "data_contratacao")
	public LocalDate getDataContratacao() {
		return dataContratacao;
	}

	public void setDataContratacao(LocalDate dataContratacao) {
		this.dataContratacao = dataContratacao;
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

	@PreUpdate
	public void preUpdate() {
		dataAtualizacao = LocalDate.now();
	}

	@PrePersist
	public void prePersist() {
		final LocalDate atual = LocalDate.now();
		dataAtualizacao = atual;
	}

	@Override
	public String toString() {
		return "Profissao [idProfissao=" + idProfissao + ", nomeEmpresa=" + nomeEmpresa + ", profissao=" + profissao
				+ ", cargo=" + cargo + ", Descricao=" + Descricao + ", salarioBruto=" + salarioBruto
				+ ", salarioLiquido=" + salarioLiquido + ", qtdSubordinados=" + qtdSubordinados + ", dataDemissao="
				+ dataDemissao + ", dataContratacao=" + dataContratacao + ", conjuge=" + conjuge + ", usuario="
				+ usuario + ", amigos=" + amigos + ", familia=" + familia + ", dataCriacao=" + dataCriacao
				+ ", dataAtualizacao=" + dataAtualizacao + "]";
	}

}
