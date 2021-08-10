package com.teste.escola.repository.aluno;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.teste.escola.model.Aluno;
import com.teste.escola.repository.filter.AlunoFilter;

public interface AlunoRepositoryQuery {

	Page<Aluno> filtrar(AlunoFilter alunoFilter, Pageable pageable);
}
