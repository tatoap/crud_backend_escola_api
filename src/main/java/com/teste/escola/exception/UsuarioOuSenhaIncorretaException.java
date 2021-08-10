package com.teste.escola.exception;

public class UsuarioOuSenhaIncorretaException extends NegocioException {

	private static final long serialVersionUID = 1L;
	
	public UsuarioOuSenhaIncorretaException(String mensagem) {
		super(mensagem);
	}
}
