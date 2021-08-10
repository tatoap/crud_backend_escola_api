package com.teste.escola.exception;

public class AlunoNaoEncontradoException extends EntidadeNaoEncontradaException {
	
	private static final long serialVersionUID = 1L;
	private static final String MSG_ALUNO_NAO_ENCONTRADO = "Não foi encontrado um aluno com o código %d";

	public AlunoNaoEncontradoException(String message) {
		super(message);
	}

	public AlunoNaoEncontradoException(Long alunoId) {
		this(String.format(MSG_ALUNO_NAO_ENCONTRADO, alunoId));
	}
	
}
