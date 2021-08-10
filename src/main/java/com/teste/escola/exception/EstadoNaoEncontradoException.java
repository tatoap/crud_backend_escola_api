package com.teste.escola.exception;

public class EstadoNaoEncontradoException extends EntidadeNaoEncontradaException {
	
	private static final long serialVersionUID = 1L;
	private static final String MSG_ESTADO_NAO_ENCONTRADO = "Não foi encontrado uma estado com o código %d";

	public EstadoNaoEncontradoException(String message) {
		super(message);
	}

	public EstadoNaoEncontradoException(Long estadoId) {
		this(String.format(MSG_ESTADO_NAO_ENCONTRADO, estadoId));
	}
}
