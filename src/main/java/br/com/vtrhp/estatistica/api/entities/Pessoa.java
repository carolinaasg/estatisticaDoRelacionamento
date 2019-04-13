package br.com.vtrhp.estatistica.api.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import br.com.vtrhp.estatistica.api.enums.NacionalidadeEnum;
import br.com.vtrhp.estatistica.api.enums.OrientacaoSexualEnum;
import br.com.vtrhp.estatistica.api.enums.PaisesEnum;
import br.com.vtrhp.estatistica.api.enums.SignosEnum;

@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3962008930812602687L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "dataNascimento")
	private LocalDate dataNascimento;
	
	@Column(name = "horaNascimento")
	private LocalTime horaNascimento;
	
	@Column(name = "altura")
	private Double altura;
	
	@Column(name = "estadoNascimento")
	private String estadoNascimento;
	
	@Column(name = "cidadeNascimento")
	private String cidadeNascimento;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "orientacaoSexual")
	private OrientacaoSexualEnum orientacaoSexual;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "paisDeOrigem")
	private PaisesEnum paisDeOrigem;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "nacionalidade")
	private NacionalidadeEnum nacionalidade;
	
	@Column(name = "adotivo")
	private char adotivo;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "signo")
	private SignosEnum signo;	
	
	@Column(name = "descendencia")
	private String descendencia;
	
	@OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<OndeConheci> ondeConheci;
	
	//LISTAS
	@OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<AssuntosDeInteresse> assuntosDeInteresse;
	
	@OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Residencia> residencia;
	
	
	//Manutenção da Tabela
	@Column(name = "dataCriacao")
	private LocalDate dataCriacao;
	
	@Column(name = "dataAtualizacao")
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
	

}
