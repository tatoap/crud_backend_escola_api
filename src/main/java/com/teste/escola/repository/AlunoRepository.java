package com.teste.escola.repository;

import org.springframework.stereotype.Repository;

import com.teste.escola.model.Aluno;
import com.teste.escola.repository.aluno.AlunoRepositoryQuery;

@Repository
public interface AlunoRepository extends CustomJpaRepository<Aluno, Long>, AlunoRepositoryQuery {

}
