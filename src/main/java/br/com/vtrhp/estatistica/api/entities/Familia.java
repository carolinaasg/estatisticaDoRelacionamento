package br.com.vtrhp.estatistica.api.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Entity
public class Familia implements Serializable {

	private static final long serialVersionUID = 4217903259530478432L;
	@Id
	private Long idFamilia;
	
	private Pessoa pessoa;

	@OneToOne(mappedBy = "familia", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Falecimento falecimento;

	@OneToMany(mappedBy = "familia", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<RelacaoComFamilia> relacaoComFamilia;

	@OneToMany(mappedBy = "familia", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<PontosPositivos> pontosPositivosFamilia;
	@OneToMany(mappedBy = "familia", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<PontosNegativos> pontosNegativosFamilia;
	@OneToMany(mappedBy = "familia", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ContatoComFamilia> contatoComFamilia;
	@OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Veiculo> veiculo;
	
	@OneToMany(mappedBy = "amigos", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Deficiencia deficiencia;

	// Manutenção da Tabela
	private LocalDate dataCriacao;
	private LocalDate dataAtualizacao;

	public Long getIdFamilia() {
		return idFamilia;
	}

	public void setIdFamilia(Long idFamilia) {
		this.idFamilia = idFamilia;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Falecimento getFalecimento() {
		return falecimento;
	}

	public void setFalecimento(Falecimento falecimento) {
		this.falecimento = falecimento;
	}

	public List<RelacaoComFamilia> getRelacaoComFamilia() {
		return relacaoComFamilia;
	}

	public void setRelacaoComFamilia(List<RelacaoComFamilia> relacaoComFamilia) {
		this.relacaoComFamilia = relacaoComFamilia;
	}

	public List<PontosPositivos> getPontosPositivosFamilia() {
		return pontosPositivosFamilia;
	}

	public void setPontosPositivosFamilia(List<PontosPositivos> pontosPositivosFamilia) {
		this.pontosPositivosFamilia = pontosPositivosFamilia;
	}

	public List<PontosNegativos> getPontosNegativosFamilia() {
		return pontosNegativosFamilia;
	}

	public void setPontosNegativosFamilia(List<PontosNegativos> pontosNegativosFamilia) {
		this.pontosNegativosFamilia = pontosNegativosFamilia;
	}

	public List<ContatoComFamilia> getContatoComFamilia() {
		return contatoComFamilia;
	}

	public void setContatoComFamilia(List<ContatoComFamilia> contatoComFamilia) {
		this.contatoComFamilia = contatoComFamilia;
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

	public List<Veiculo> getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(List<Veiculo> veiculo) {
		this.veiculo = veiculo;
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

}
