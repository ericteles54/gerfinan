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
	private TipoTransacao tipoTransacao;
	
	@Column(name = "valor")
	@NotEmpty(message = "Por favor preencha o campo valor.")
	private BigDecimal valor;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name = "conta_id", referencedColumnName = "conta_id")
	private Conta conta;
	
}
