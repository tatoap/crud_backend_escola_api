package com.teste.escola.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.teste.escola.model.Usuario;

@Repository
public interface UsuarioRepository extends CustomJpaRepository<Usuario, Long> {

	public Optional<Usuario> findByEmail(String email);
	
	public List<Usuario> findByPermissoesDescricao(String permissaoDescricao);
}
