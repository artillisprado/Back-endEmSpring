package com.artillis.urbana.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.artillis.urbana.domain.Cartao;

public interface PessoaRepository extends JpaRepository<Cartao, Integer>{

}
