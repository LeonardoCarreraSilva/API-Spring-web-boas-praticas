package com.github.LeonardoCarreraSilva.ApiRestBoasPraticas.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.github.LeonardoCarreraSilva.ApiRestBoasPraticas.Dto.PessoaDto;
import com.github.LeonardoCarreraSilva.ApiRestBoasPraticas.controller.form.FormPessoa;
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
//			ex: http://localhost:8080/pessoa?nome=Leonardo
			return PessoaDto.converter(pessoas);	
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PessoaDto> listarPorId(@PathVariable Long id){
		Optional<Pessoa> pessoa = pessoaRepository.findById(id);
		if(pessoa.isPresent()) {
			return ResponseEntity.ok(new PessoaDto(pessoa.get()));
		}else {			
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<PessoaDto> salvar(@RequestBody @Valid FormPessoa formPessoa,
			UriComponentsBuilder uriBuilder){
		Pessoa pessoa = formPessoa.converter();
		pessoaRepository.save(pessoa);
		
		URI uri = uriBuilder.path("/pessoa/{id}").buildAndExpand(pessoa.getId()).toUri();
		return ResponseEntity.created(uri).body(new PessoaDto(pessoa));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<PessoaDto> atualizarPessoa(@PathVariable Long id, @RequestBody @Valid FormPessoa form){
		Optional<Pessoa> optional = pessoaRepository.findById(id);
		if(optional.isPresent()) {
			Pessoa pessoa = form.atualizar(id, pessoaRepository);
			return ResponseEntity.ok(new PessoaDto(pessoa));
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
}
