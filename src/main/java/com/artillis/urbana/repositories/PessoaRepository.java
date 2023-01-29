package com.artillis.urbana.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.artillis.urbana.domain.Cartao;
import com.artillis.urbana.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Cartao, Integer>{
	Optional<Pessoa> findByCpf(String cpf);
	Optional<Pessoa> findByEmail(String email);
}
