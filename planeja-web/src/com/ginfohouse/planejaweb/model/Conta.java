package com.ginfohouse.planejaweb.model;

public abstract class Conta {
	private Long idConta;//gerado automaticamente pelo banco de dados
	private Long idUser;//retornado pelos dados do usuario logado na sessão
	private float taxaJuros;
	private double valor;
	public Long getIdConta() {
		return idConta;
	}
	public void setIdConta(Long idConta) {
		this.idConta = idConta;
	}
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public float getTaxaJuros() {
		return taxaJuros;
	}
	public void setTaxaJuros(float taxaJuros) {
		this.taxaJuros = taxaJuros;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
}
