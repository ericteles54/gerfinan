package br.com.qualidadeintegrada.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.qualidadeintegrada.application.model.Conta;
import br.com.qualidadeintegrada.security.model.User;

public interface ContaRepository extends JpaRepository<Conta, Integer> {

	Conta findByNome(String nome);
	
	List<Conta> findByUser(User user);	
	
}
