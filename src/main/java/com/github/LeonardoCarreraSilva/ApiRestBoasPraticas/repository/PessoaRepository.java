package com.github.LeonardoCarreraSilva.ApiRestBoasPraticas.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.github.LeonardoCarreraSilva.ApiRestBoasPraticas.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

	Page<Pessoa> findByNome(String nome, Pageable paginacao);
	
}
