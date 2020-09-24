package com.github.LeonardoCarreraSilva.ApiRestBoasPraticas.Dto;

import java.util.List;
import java.util.stream.Collectors;

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
	
	public static List<PessoaDto> converter(List<Pessoa> pessoas){
		return pessoas.stream().map(PessoaDto::new).collect(Collectors.toList());
	}

}
