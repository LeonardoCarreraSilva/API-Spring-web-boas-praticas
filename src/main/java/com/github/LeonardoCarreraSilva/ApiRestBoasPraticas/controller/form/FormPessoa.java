package com.github.LeonardoCarreraSilva.ApiRestBoasPraticas.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.dialect.lock.PessimisticEntityLockException;

import com.github.LeonardoCarreraSilva.ApiRestBoasPraticas.model.Pessoa;
import com.github.LeonardoCarreraSilva.ApiRestBoasPraticas.repository.PessoaRepository;


public class FormPessoa {
	@NotNull
	@NotEmpty
	private String nome;
	@NotNull
	@NotEmpty
	private String sobrenome;
	@NotNull
	@NotEmpty
	private char sexo;

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public char getSexo() {
		return sexo;
	}
	
	public Pessoa converter() {
		return new Pessoa(nome, sobrenome, sexo);
	}
	
	public Pessoa atualizar(Long id, PessoaRepository pessoaRepository) {
		Pessoa pessoa = pessoaRepository.getOne(id);
		pessoa.setNome(this.nome);
		pessoa.setSobrenome(this.sobrenome);
		pessoa.setSexo(this.sexo);
		return pessoa;
	}
}
