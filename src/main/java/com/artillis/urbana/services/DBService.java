package com.artillis.urbana.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artillis.urbana.domain.Cartao;
import com.artillis.urbana.domain.Chamado;
import com.artillis.urbana.domain.Cliente;
import com.artillis.urbana.domain.enums.Perfil;
import com.artillis.urbana.domain.enums.Status;
import com.artillis.urbana.repositories.CartaoRepository;
import com.artillis.urbana.repositories.ChamadoRepository;
import com.artillis.urbana.repositories.ClienteRepository;

@Service
public class DBService {
	
	@Autowired
	private CartaoRepository cartaoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired 
	private ChamadoRepository chamadoRepository;
	
	public void instanciaDB() {
		Cartao cart1 = new Cartao(null, "Vem Trabalhador", "620.524.970-72", 2);
		Cartao cart2 = new Cartao(null, "Vem Estudante", "903.347.070-56", 1);
		Cartao cart3 = new Cartao(null, "Vem Trabalhador", "271.068.470-54", 2);
		Cartao cart4 = new Cartao(null, "Vem Trabalhador", "162.720.120-39", 2);
		Cartao cart5 = new Cartao(null, "Vem Estudante", "778.556.170-27", 1);
		
		Cliente cli1 = new Cliente(null, "Linus Trovados", "705.962.580-11", "l@mail.com", "123");
		Cliente cli2 = new Cliente(null, "Marie Curie", "322.429.140-06", "curie@mail.com", "123");
		Cliente cli3 = new Cliente(null, "Charles Darwin", "792.043.830-62", "darwin@mail.com", "123");
		Cliente cli4 = new Cliente(null, "Stephen Hawking", "177.409.680-30", "hawking@mail.com", "123");
		Cliente cli5 = new Cliente(null, "Max Planck", "081.399.300-83", "planck@mail.com", "123");
		
		Chamado c1 = new Chamado(null, Status.ATIVO, "Usuario 01", "Vale transporte Trabalhador", cart1, cli1);
		Chamado c2 = new Chamado(null, Status.ATIVO, "Chamado 2", "Vale transporte Estudante", cart1, cli2);
		Chamado c3 = new Chamado(null, Status.INATIVO, "Chamado 3", "Vale transporte Trabalhador", cart2, cli3);
		Chamado c4 = new Chamado(null, Status.ATIVO, "Chamado 4", "Vale transporte Trabalhador", cart3, cli3);
		Chamado c5 = new Chamado(null, Status.INATIVO, "Chamado 5", "Vale transporte Estudante", cart2, cli1);
		Chamado c6 = new Chamado(null, Status.INATIVO, "Chamado 7", "ale transporte Trabalhador", cart1, cli5);
		
		cartaoRepository.saveAll(Arrays.asList(cart1, cart2, cart3, cart4, cart5));
		clienteRepository.saveAll(Arrays.asList(cli1, cli2, cli3, cli4, cli5));
		chamadoRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6));
	}
}
