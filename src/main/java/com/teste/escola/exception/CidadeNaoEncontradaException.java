package com.teste.escola.exception;

public class CidadeNaoEncontradaException extends EntidadeNaoEncontradaException {
	
	private static final long serialVersionUID = 1L;
	private static final String MSG_CIDADE_NAO_ENCONTRADA = "Não foi encontrado uma cidade com o código %d";

	public CidadeNaoEncontradaException(String message) {
		super(message);
	}

	public CidadeNaoEncontradaException(Long cidadeId) {
		this(String.format(MSG_CIDADE_NAO_ENCONTRADA, cidadeId));
	}
	
}
