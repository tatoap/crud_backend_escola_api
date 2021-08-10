package com.teste.escola.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.teste.escola.model.Usuario;

import lombok.Getter;

@Getter
public class UsuarioSistema extends User {

private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	
	public UsuarioSistema(Usuario usuario, Collection<? extends GrantedAuthority> authorities) {
		super(usuario.getEmail(), usuario.getSenha(), authorities);
		this.usuario = usuario;
	}
}
