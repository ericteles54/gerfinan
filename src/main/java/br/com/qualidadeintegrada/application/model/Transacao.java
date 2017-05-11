package br.com.qualidadeintegrada.application.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "transacao")
public class Transacao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "transacao_id")
	private long transacao_id;
	
	@Column(name = "consolidada")
	@NotNull
	private boolean consolidada;
	
	@Column(name = "aplicacao")
	@NotNull
	private boolean aplicacao;
	
	@Column(name = "transferencia")
	@NotNull
	private boolean transferencia;
	
	@NotEmpty(message = "Por favor insira uma data.")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@Temporal(TemporalType.DATE)
	@Column(name = "data")
	private Date data;
	
	@Column(name = "descricao")
	@NotEmpty(message = "Por favor, preencha o campo descrição")
	private String descricao;
	
	@Enumerated(EnumType.STRING)
	@NotEmpty(message = "Por favor selecione o tipo de transação.")
	@Column(name = "tipo_transacao")
	private TipoTransacaoEnun tipoTransacaoEnun;
	
	@Column(name = "valor")
	@NotEmpty(message = "Por favor preencha o campo valor.")
	private BigDecimal valor;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name = "conta_id", referencedColumnName = "conta_id")
	private Conta conta;

	
	
	public long getTransacao_id() {
		return transacao_id;
	}

	public void setTransacao_id(long transacao_id) {
		this.transacao_id = transacao_id;
	}

	public boolean isConsolidada() {
		return consolidada;
	}

	public void setConsolidada(boolean consolidada) {
		this.consolidada = consolidada;
	}

	public boolean isAplicacao() {
		return aplicacao;
	}

	public void setAplicacao(boolean aplicacao) {
		this.aplicacao = aplicacao;
	}

	public boolean isTransferencia() {
		return transferencia;
	}

	public void setTransferencia(boolean transferencia) {
		this.transferencia = transferencia;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoTransacaoEnun getTipoTransacaoEnun() {
		return tipoTransacaoEnun;
	}

	public void setTipoTransacaoEnun(TipoTransacaoEnun tipoTransacaoEnun) {
		this.tipoTransacaoEnun = tipoTransacaoEnun;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}	
}
