package br.com.vtrhp.estatistica.api.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import br.com.vtrhp.estatistica.api.enums.ProblemasVisao;

@Entity
@Table(name = "visao")
public class Visao implements Serializable {

	private static final long serialVersionUID = -5501459470347058476L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idVisao;
	private Double grauEsquerdo;
	private Double grauDireito;
	@Enumerated(EnumType.STRING)
	private ProblemasVisao tipoEsquerdo;
	@Enumerated(EnumType.STRING)
	private ProblemasVisao tipoDireito;
	private String usaOculos;
	private String fezCirurgia;
	private String usaLente;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_conjuge")
	private Conjuge conjuge;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_familia")
	private Familia familia;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_amigo")
	private Amigos amigos;

	private LocalDate dataCriacao;
	private LocalDate dataAtualizacao;

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

	@Column(name = "id_visao")
	public Long getIdVisao() {
		return idVisao;
	}

	public void setIdVisao(Long idVisao) {
		this.idVisao = idVisao;
	}

	@Column(name = "grau_esquerdo")
	public Double getGrauEsquerdo() {
		return grauEsquerdo;
	}

	public void setGrauEsquerdo(Double grauEsquerdo) {
		this.grauEsquerdo = grauEsquerdo;
	}

	@Column(name = "grau_direito")
	public Double getGrauDireito() {
		return grauDireito;
	}

	public void setGrauDireito(Double grauDireito) {
		this.grauDireito = grauDireito;
	}

	@Column(name = "tipo_esquerdo")
	public ProblemasVisao getTipoEsquerdo() {
		return tipoEsquerdo;
	}

	public void setTipoEsquerdo(ProblemasVisao tipoEsquerdo) {
		this.tipoEsquerdo = tipoEsquerdo;
	}

	@Column(name = "tipo_direito")
	public ProblemasVisao getTipoDireito() {
		return tipoDireito;
	}

	public void setTipoDireito(ProblemasVisao tipoDireito) {
		this.tipoDireito = tipoDireito;
	}

	@Column(name = "usa_oculos")
	public String getUsaOculos() {
		return usaOculos;
	}

	public void setUsaOculos(String usaOculos) {
		this.usaOculos = usaOculos;
	}

	@Column(name = "fez_cirurgia")
	public String getFezCirurgia() {
		return fezCirurgia;
	}

	public void setFezCirurgia(String fezCirurgia) {
		this.fezCirurgia = fezCirurgia;
	}

	@Column(name = "usa_lente")
	public String getUsaLente() {
		return usaLente;
	}

	public void setUsaLente(String usaLente) {
		this.usaLente = usaLente;
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

	public Familia getFamilia() {
		return familia;
	}

	public void setFamilia(Familia familia) {
		this.familia = familia;
	}

	public Amigos getAmigos() {
		return amigos;
	}

	public void setAmigos(Amigos amigos) {
		this.amigos = amigos;
	}

	@Override
	public String toString() {
		return "Visao [idVisao=" + idVisao + ", grauEsquerdo=" + grauEsquerdo + ", grauDireito=" + grauDireito
				+ ", tipoEsquerdo=" + tipoEsquerdo + ", tipoDireito=" + tipoDireito + ", usaOculos=" + usaOculos
				+ ", fezCirurgia=" + fezCirurgia + ", usaLente=" + usaLente + ", conjuge=" + conjuge + ", usuario="
				+ usuario + ", familia=" + familia + ", amigos=" + amigos + ", dataCriacao=" + dataCriacao
				+ ", dataAtualizacao=" + dataAtualizacao + "]";
	}
	
	

}
