package com.artillis.urbana.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.artillis.urbana.domain.Cartao;
import com.artillis.urbana.domain.dtos.CartaoDTO;
import com.artillis.urbana.services.CartaoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/cartao")
public class ClienteResource {
	
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
	
	@PostMapping
	public ResponseEntity<CartaoDTO> create(@RequestBody CartaoDTO objDTO) {
		Cartao newObj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<CartaoDTO> update(@PathVariable Integer id,@Valid @RequestBody CartaoDTO objDTO) {
		Cartao obj = service.update(id, objDTO);
		return ResponseEntity.ok().body(new CartaoDTO(obj));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<CartaoDTO> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
