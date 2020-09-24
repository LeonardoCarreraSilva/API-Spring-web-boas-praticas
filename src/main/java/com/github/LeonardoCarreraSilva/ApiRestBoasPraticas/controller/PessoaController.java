package com.github.LeonardoCarreraSilva.ApiRestBoasPraticas.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public Page<PessoaDto> listar(@RequestParam(required = false) String nome,
			@PageableDefault(sort = "id", direction = Direction.ASC, size = 10) Pageable paginacao) {
		if(nome == null) {
			Page<Pessoa> pessoas = pessoaRepository.findAll(paginacao);
			return PessoaDto.converter(pessoas);
		}else {
			Page<Pessoa> pessoas = pessoaRepository.findByNome(nome, paginacao);
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
	public ResponseEntity<PessoaDto> salvar (@RequestBody @Valid FormPessoa formPessoa,
			UriComponentsBuilder uriBuilder){
		Pessoa pessoa = formPessoa.converter();
		pessoaRepository.save(pessoa);
		
		URI uri = uriBuilder.path("/pessoa/{id}").buildAndExpand(pessoa.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new PessoaDto(pessoa));
	}
	
	@PutMapping(value = "/{id}")
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
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id){
		Optional<Pessoa> pessoa = pessoaRepository.findById(id);
		if (pessoa.isPresent()) {
			pessoaRepository.deleteById(id);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
}
