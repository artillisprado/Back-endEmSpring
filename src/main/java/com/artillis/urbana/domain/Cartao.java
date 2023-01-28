package com.artillis.urbana.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Cartao extends Pessoa{
	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "cliente")
	private List<Chamado> chamados = new ArrayList<>();

	public Cartao() {
		super();
	}

	public Cartao(Integer id, String nome, String cpf, String email, String senha) {
		super(id, nome, cpf, email, senha);
	}

	public List<Chamado> getChamados() {
		return chamados;
	}

	public void setChamados(List<Chamado> chamados) {
		this.chamados = chamados;
	}
	
	
	
}
