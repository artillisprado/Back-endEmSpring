package com.artillis.urbana.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artillis.urbana.domain.Chamado;
import com.artillis.urbana.repositories.ChamadoRepository;
import com.artillis.urbana.services.exceptions.ObjectnotFoundException;

@Service
public class ChamadoService {
	
	@Autowired
	private ChamadoRepository repository;
	
	public Chamado findById(Integer id) {
		Optional<Chamado> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! ID: "+ id));
	}
}
