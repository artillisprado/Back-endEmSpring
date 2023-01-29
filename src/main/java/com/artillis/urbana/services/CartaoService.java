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
