package com.artillis.urbana.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.artillis.urbana.domain.dtos.CartaoDTO;
import com.artillis.urbana.domain.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Cartao extends Pessoa{
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@OneToMany(mappedBy = "cartao")
	private List<Chamado> chamados = new ArrayList<>();
	
	@Column(unique = true)
	private String cartao;

	public Cartao() {
		super();
	}
	
	public Cartao(Integer id, String nome, String cartao, Integer perfil) {
		this.nome = nome;
		this.cartao = cartao;

		if(perfil == 0) {
			addPerfil(Perfil.COMUM);
		} else if (perfil == 1){
			addPerfil(Perfil.ESTUDANTE);
		} else if (perfil == 2) {
			addPerfil(Perfil.TRABALHADOR);
		}
	}
	
	public Cartao(CartaoDTO obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cartao = obj.getCartao();
		this.perfis = obj.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
		this.dataCriacao = obj.getDataCriacao();
	}

	public List<Chamado> getChamados() {
		return chamados;
	}

	public void setChamados(List<Chamado> chamados) {
		this.chamados = chamados;
	}
	
	public String getCartao() {
		return cartao;
	}

	public void setCartao(String cartao) {
		this.cartao = cartao;
	}
}
