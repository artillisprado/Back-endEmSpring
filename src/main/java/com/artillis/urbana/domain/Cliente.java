package com.artillis.urbana.domain;

import java.util.ArrayList;
import java.util.List;

import com.artillis.urbana.domain.enums.Perfil;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Cliente extends Pessoa {
	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "cliente")
	private List<Chamado> chamados = new ArrayList<>();

	public Cliente() {
		super();
		addPerfil(Perfil.COMUM);
	}

	public Cliente(Integer id, String nome, String cpf, String email, String senha) {
		super(id, nome, cpf, email, senha);
		addPerfil(Perfil.COMUM);
	}

	public List<Chamado> getChamados() {
		return chamados;
	}

	public void setChamados(List<Chamado> chamados) {
		this.chamados = chamados;
	}
}
