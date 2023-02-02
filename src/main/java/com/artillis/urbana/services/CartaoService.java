package com.artillis.urbana.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artillis.urbana.domain.Cartao;
import com.artillis.urbana.domain.dtos.CartaoDTO;
import com.artillis.urbana.repositories.CartaoRepository;
import com.artillis.urbana.services.exceptions.DataIntegrityViolationException;
import com.artillis.urbana.services.exceptions.ObjectnotFoundException;

import jakarta.validation.Valid;

@Service
public class CartaoService {
	
	@Autowired
	private CartaoRepository repository;
	
	public Cartao findById(Integer id) {
		Optional<Cartao> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado ! id: " + id));
	}

	public List<Cartao> findAll() {
		return repository.findAll();
	}

	public Cartao create(CartaoDTO objDTO) {
		objDTO.setId(null);
		Cartao newObj = new Cartao(objDTO);
		return repository.save(newObj);
	}
	
	public Cartao update(Integer id, @Valid CartaoDTO objDTO) {
		objDTO.setId(id);
		Cartao oldObj = findById(id);
		oldObj = new Cartao(objDTO);
		return repository.save(oldObj);
	}
	
	public void delete(Integer id) {
		Cartao obj = findById(id);
		if(obj.getChamados().size() > 0) {
			throw new DataIntegrityViolationException("O usuario possui mais de um cartão, e não pode ser deletado.");
		} 
		repository.deleteById(id);
	}
}
