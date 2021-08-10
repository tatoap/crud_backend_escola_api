package com.teste.escola.repository;

import org.springframework.stereotype.Repository;

import com.teste.escola.model.Turma;
import com.teste.escola.repository.turma.TurmaRepositoryQuery;

@Repository
public interface TurmaRepository extends CustomJpaRepository<Turma, Long>, TurmaRepositoryQuery {

}
