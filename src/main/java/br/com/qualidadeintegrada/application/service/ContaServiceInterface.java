package br.com.qualidadeintegrada.application.service;

import java.util.List;

import br.com.qualidadeintegrada.application.model.Conta;
import br.com.qualidadeintegrada.security.model.User;

public interface ContaServiceInterface {

	public Conta findByNome(String nome);
	
	public List<Conta> findByUser(User user);
	
	public void saveConta(Conta conta);
	
}
