package com.github.LeonardoCarreraSilva.ApiRestBoasPraticas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.LeonardoCarreraSilva.ApiRestBoasPraticas.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

	List<Pessoa> findByNome(String nome);
	
}
