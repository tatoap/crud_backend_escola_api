package com.teste.escola.repository.turma;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.teste.escola.model.Turma;
import com.teste.escola.repository.filter.TurmaFilter;

public interface TurmaRepositoryQuery {
	
	Page<Turma> filtrar(TurmaFilter turmaFilter, Pageable pageable);

}
