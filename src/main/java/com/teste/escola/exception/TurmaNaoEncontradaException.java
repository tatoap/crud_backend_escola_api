package com.teste.escola.exception;

public class TurmaNaoEncontradaException extends EntidadeNaoEncontradaException {
	
	private static final long serialVersionUID = 1L;
	private static final String MSG_TURMA_NAO_ENCONTRADA = "Não foi encontrado uma turma com o código %d";

	public TurmaNaoEncontradaException(String message) {
		super(message);
	}

	public TurmaNaoEncontradaException(Long turmaId) {
		this(String.format(MSG_TURMA_NAO_ENCONTRADA, turmaId));
	}
	
}
