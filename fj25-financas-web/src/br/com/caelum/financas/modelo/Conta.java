package br.com.caelum.financas.modelo;

import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Cacheable
@Table(uniqueConstraints= {@UniqueConstraint(columnNames={"agencia", "numero"})})
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull @Pattern(regexp="[A-Z].*")
	private String titular;
	@NotEmpty
	private String agencia;
	@NotEmpty
	private String numero;
	@NotEmpty
//	@Column(length=20, nullable=false)
	private String banco;
	
	@Cache(usage=CacheConcurrencyStrategy.TRANSACTIONAL)
	@OneToMany(mappedBy="conta")
	private List<Movimentacao> movimentacoes;
//	@Version
//	private Integer versao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public List<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}

	public void setMovimentacoes(List<Movimentacao> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}

//	public final Integer getVersao() {
//		return versao;
//	}

//	public final void setVersao(Integer versao) {
//		this.versao = versao;
//	}
	
	

}
