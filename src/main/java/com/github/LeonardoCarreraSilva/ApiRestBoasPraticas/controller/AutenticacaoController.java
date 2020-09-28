package com.github.LeonardoCarreraSilva.ApiRestBoasPraticas.controller;

import javax.validation.Valid;

import org.h2.security.auth.AuthConfigException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.LeonardoCarreraSilva.ApiRestBoasPraticas.Dto.TokenDto;
import com.github.LeonardoCarreraSilva.ApiRestBoasPraticas.conf.TokenService;
import com.github.LeonardoCarreraSilva.ApiRestBoasPraticas.controller.form.LoginForm;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<TokenDto> autenticar(@RequestBody @Valid LoginForm form){
		UsernamePasswordAuthenticationToken dadosLogin = form.converter();
		try {
			Authentication authenticate = authenticationManager.authenticate(dadosLogin);
			String token = TokenService.gerarToken(authenticate);
			return ResponseEntity.ok(new TokenDto(token, "Bearer"));
		} catch (AuthConfigException e) {
			// TODO: handle exceptionð
			return ResponseEntity.badRequest().build();
		}
		
	}
}
