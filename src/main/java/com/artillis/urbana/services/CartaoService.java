package com.artillis.urbana.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artillis.urbana.domain.Cartao;
import com.artillis.urbana.domain.Pessoa;
import com.artillis.urbana.domain.dtos.CartaoDTO;
import com.artillis.urbana.repositories.CartaoRepository;
import com.artillis.urbana.repositories.PessoaRepository;
import com.artillis.urbana.services.exceptions.DataIntegrityViolationException;
import com.artillis.urbana.services.exceptions.ObjectnotFoundException;

import jakarta.validation.Valid;

@Service
public class CartaoService {
	
	@Autowired
	private CartaoRepository repository;
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Cartao findById(Integer id) {
		Optional<Cartao> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado ! id: " + id));
	}

	public List<Cartao> findAll() {
		return repository.findAll();
	}

	public Cartao create(CartaoDTO objDTO) {
		objDTO.setId(null);
		validaporCPFEEMAIL(objDTO);
		Cartao newObj = new Cartao(objDTO);
		return repository.save(newObj);
	}
	
	public Cartao update(Integer id, @Valid CartaoDTO objDTO) {
		objDTO.setId(id);
		Cartao oldObj = findById(id);
		validaporCPFEEMAIL(objDTO);
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

	private void validaporCPFEEMAIL(CartaoDTO objDTO) {
		Optional<Pessoa> obj = pessoaRepository.findByCpf(objDTO.getCpf());
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("CPF já Cadastrado no Sistema !");
		}
		
		obj = pessoaRepository.findByEmail(objDTO.getEmail());
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("Email já Cadastrado no Sistema !");
		}
		
	}
}
