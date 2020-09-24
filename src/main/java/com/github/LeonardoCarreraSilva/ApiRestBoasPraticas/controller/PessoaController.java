package com.github.LeonardoCarreraSilva.ApiRestBoasPraticas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.LeonardoCarreraSilva.ApiRestBoasPraticas.Dto.PessoaDto;
import com.github.LeonardoCarreraSilva.ApiRestBoasPraticas.model.Pessoa;
import com.github.LeonardoCarreraSilva.ApiRestBoasPraticas.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	
	@GetMapping
	public List<PessoaDto> listar(String nome) {
		if(nome == null) {
			List<Pessoa> pessoas = pessoaRepository.findAll();
			return PessoaDto.converter(pessoas);
		}else {
			List<Pessoa> pessoas = pessoaRepository.findByNome(nome);
			return PessoaDto.converter(pessoas);	
		}
	}
	
	
}
