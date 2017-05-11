package br.com.qualidadeintegrada.application.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.qualidadeintegrada.application.model.Transacao;
import br.com.qualidadeintegrada.application.repository.TransacaoRepository;

@Service("transacaoService")
public class TransacaoServiceImpl implements TransacaoServiceInterface {

	@Autowired
	private TransacaoRepository transacaoRepository;

	@Override
	public Transacao findByData(Date data) {
		
		return transacaoRepository.findByData(data);
	}

	@Override
	public void saveTransacao(Transacao transacao) {
		
		transacaoRepository.save(transacao);		
	}
	
	
}
