package com.artillis.urbana.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.artillis.urbana.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
