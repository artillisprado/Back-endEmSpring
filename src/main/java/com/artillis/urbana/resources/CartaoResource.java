package com.artillis.urbana.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.artillis.urbana.domain.Cartao;
import com.artillis.urbana.domain.dtos.CartaoDTO;
import com.artillis.urbana.services.CartaoService;

@RestController
@RequestMapping(value = "/cartao")
public class CartaoResource {
	
	//localhost:8080/cartao/1
	
	@Autowired
	private CartaoService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CartaoDTO> findById(@PathVariable Integer id) {
		Cartao obj = service.findById(id);
		return ResponseEntity.ok().body(new CartaoDTO(obj));
	}
	
	@GetMapping
	public ResponseEntity<List<CartaoDTO>> findAll() {
		List<Cartao> list = service.findAll();
		List<CartaoDTO> listDto = list.stream().map(obj -> new CartaoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
}
