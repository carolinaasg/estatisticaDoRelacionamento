package br.com.vtrhp.estatistica.api.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import br.com.vtrhp.estatistica.api.enums.AplicativosDeRelacionamentoEnum;

@Entity
@Table(name = "ondeConheci")
public class OndeConheci {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private AplicativosDeRelacionamentoEnum app;
	private String nome;
	private String descricao;
	private String cidade;
	private String Estado;
	private LocalDate data;
	private LocalTime hora;
	
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
	
	
	
	

}
