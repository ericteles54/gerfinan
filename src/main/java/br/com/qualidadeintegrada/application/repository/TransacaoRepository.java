package br.com.qualidadeintegrada.application.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.qualidadeintegrada.application.model.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

	Transacao findByData(Date data);
}
