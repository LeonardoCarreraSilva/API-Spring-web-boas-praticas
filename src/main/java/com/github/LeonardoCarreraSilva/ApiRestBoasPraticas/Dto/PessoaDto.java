package com.github.LeonardoCarreraSilva.ApiRestBoasPraticas.Dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import com.github.LeonardoCarreraSilva.ApiRestBoasPraticas.model.Pessoa;

public class PessoaDto {
	
	private Long id;
	
	private String nome;
	
	private String sobrenome;
	
	private char sexo;
	
	public PessoaDto(Pessoa pessoa) {
		this.id = pessoa.getId();
		this.nome = pessoa.getNome();
		this.sobrenome = pessoa.getSobrenome();
		this.sexo = pessoa.getSexo();
	}
	
	

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public char getSexo() {
		return sexo;
	}
	
	public static Page<PessoaDto> converter(Page<Pessoa> pessoas){
		return pessoas.map(PessoaDto::new);
	}

}
