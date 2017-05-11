package br.com.qualidadeintegrada.application.model;

public enum TipoTransacaoEnun {
	
	DESPESA("Despesa"),
	RECEITA("Receita"),
	TRANSFERENCIA("Transferencia");
	
	private String descricao;
	
	TipoTransacaoEnun(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}

}
