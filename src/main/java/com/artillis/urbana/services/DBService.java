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
	@Autowired ChamadoRepository chamadoRepository;
	
	public void instanciaDB() {
		Cartao cart1 = new Cartao(null, "Luiz Nunes", "345.880.000-04", "nunes@mail.com", "123");
		cart1.addPerfil(Perfil.COMUM);
		
		Cliente cli1 = new Cliente(null, "Linus Trovados", "705.962.580-11", "linus@mail.com", "123");
		
		Chamado c1 = new Chamado(null, Status.ATIVO, "Usuario 01", "Vale transporte comum", cart1, cli1);
	
		cartaoRepository.saveAll(Arrays.asList(cart1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
	}
}
