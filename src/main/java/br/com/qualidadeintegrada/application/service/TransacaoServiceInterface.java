package br.com.qualidadeintegrada.application.service;

import java.util.Date;

import br.com.qualidadeintegrada.application.model.Transacao;

public interface TransacaoServiceInterface {

	public Transacao findByData(Date data);
	
	public void saveTransacao(Transacao transacao);
}
