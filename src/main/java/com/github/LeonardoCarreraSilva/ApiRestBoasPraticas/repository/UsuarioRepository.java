package com.github.LeonardoCarreraSilva.ApiRestBoasPraticas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.LeonardoCarreraSilva.ApiRestBoasPraticas.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	Optional<Usuario> findByEmail(String email);
}
