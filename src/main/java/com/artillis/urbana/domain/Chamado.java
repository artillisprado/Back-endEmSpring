package com.artillis.urbana.domain;

import java.time.LocalDate;

import com.artillis.urbana.domain.enums.Status;

public class Chamado {

	private Integer id;
	private LocalDate dataAbertura = LocalDate.now();
	private LocalDate dataFechamento;
	private Status status;
	private String titulo;
	private String observacoes;
	
	private Cartao cartao;
	private Cliente cliente;

	public Chamado() {
		super();
	}

	public Chamado(Integer id, Status status, String titulo, String observacoes, Cartao cartao, Cliente cliente) {
		super();
		this.id = id;
		this.status = status;
		this.titulo = titulo;
		this.observacoes = observacoes;
		this.cartao = cartao;
		this.cliente = cliente;
	}
	
	
}
