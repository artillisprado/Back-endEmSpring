package com.artillis.urbana.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artillis.urbana.domain.Cartao;
import com.artillis.urbana.repositories.CartaoRepository;

@Service
public class CartaoService {
	
	@Autowired
	private CartaoRepository repository;
	
	public Cartao findById(Integer id) {
		Optional<Cartao> obj = repository.findById(id);
		return obj.orElse(null);
	}
}
