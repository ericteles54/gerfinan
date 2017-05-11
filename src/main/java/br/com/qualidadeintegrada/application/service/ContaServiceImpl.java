package br.com.qualidadeintegrada.application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.qualidadeintegrada.application.model.Conta;
import br.com.qualidadeintegrada.application.repository.ContaRepository;
import br.com.qualidadeintegrada.security.model.User;

@Service("contaService")
public class ContaServiceImpl implements ContaServiceInterface {

	@Autowired
	private ContaRepository contaRepository;

	@Override
	public Conta findByNome(String nome) {
		
		return contaRepository.findByNome(nome);
	}
	
	@Override
	public List<Conta> findByUser(User user) {
		
		List<Conta> contas = new ArrayList<Conta>();
		contas = contaRepository.findByUser(user);
		
		return contas;
	}

	@Override
	public void saveConta(Conta conta) {
		
		contaRepository.save(conta);
	}
	
}
