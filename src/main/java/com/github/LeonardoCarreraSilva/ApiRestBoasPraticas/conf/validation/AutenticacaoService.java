package com.github.LeonardoCarreraSilva.ApiRestBoasPraticas.conf.validation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.github.LeonardoCarreraSilva.ApiRestBoasPraticas.model.Usuario;
import com.github.LeonardoCarreraSilva.ApiRestBoasPraticas.repository.UsuarioRepository;

@Service
public class AutenticacaoService implements UserDetailsService{
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> findByEmail = usuarioRepository.findByEmail(username);
		if(findByEmail.isPresent()) {
			return findByEmail.get();
		}
		throw new UsernameNotFoundException("Dados não encontrados");
	}

}
