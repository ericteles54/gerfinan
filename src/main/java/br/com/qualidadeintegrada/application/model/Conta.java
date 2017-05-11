package br.com.qualidadeintegrada.application.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.qualidadeintegrada.security.model.User;

@Entity
@Table(name = "conta")
public class Conta implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "conta_id")
	private int conta_id;
	
	@Column(name = "nome")
	@NotEmpty(message = "Por favor insira um nome para a conta.")
	private String nome;
	
	@Column(name = "saldo")
	@NotEmpty(message = "Por favor insira o saldo inicial da conta.")
	private BigDecimal saldo;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private User user;

	@OneToMany(mappedBy = "conta")
	@NotNull
	private List<Transacao> transacoes;
	
	
	
	
	
	public int getConta_id() {
		return conta_id;
	}

	public void setConta_id(int conta_id) {
		this.conta_id = conta_id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Transacao> getTransacoes() {
		return transacoes;
	}

	public void setTransacoes(List<Transacao> transacoes) {
		this.transacoes = transacoes;
	}
		
}
