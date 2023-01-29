package com.artillis.urbana.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artillis.urbana.domain.Cartao;
import com.artillis.urbana.repositories.CartaoRepository;
import com.artillis.urbana.services.exceptions.ObjectnotFoundException;

@Service
public class CartaoService {
	
	@Autowired
	private CartaoRepository repository;
	
	public Cartao findById(Integer id) {
		Optional<Cartao> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado ! id: " + id));
	}
}
