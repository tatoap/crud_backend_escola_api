package com.teste.escola.api.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {

	MENSAGEM_INCOMPREENSIVEL("/mensagem-incompreensivel", "Mensagem incompreensivel"),
	ERRO_NEGOCIO("/erro-negocio", "Violação de regra de negócio"),
	RECURSO_NAO_ENCONTRADO("/recurso-nao-encontrado", "Recurso não encontrado"),
	DADOS_INVALIDOS("/dados-invalidos", "Dados inválidos"),
	ERRO_DE_SISTEMA("/erro-sistema", "Erro de sistema"),
	ACESSO_NEGADO("/acesso-negado", "Acesso negado");
	
	private String title;
	private String uri;
	
	ProblemType(String path, String title) {
		this.uri = "https://cadastroescola.com.br" + path;
		this.title = title;
	}
}
