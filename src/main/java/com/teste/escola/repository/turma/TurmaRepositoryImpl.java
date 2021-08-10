package com.teste.escola.repository.turma;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.ObjectUtils;

import com.teste.escola.model.Turma;
import com.teste.escola.repository.filter.TurmaFilter;

public class TurmaRepositoryImpl implements TurmaRepositoryQuery {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<Turma> filtrar(TurmaFilter turmaFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Turma> criteria = builder.createQuery(Turma.class);
		Root<Turma> root = criteria.from(Turma.class);
		
		System.out.println("passei aqui filtrar " + turmaFilter.getNome());

		Predicate[] predicates = criarRestricoes(turmaFilter, builder, root);
		
		criteria.where(predicates);
		
		TypedQuery<Turma> query = manager.createQuery(criteria.orderBy(builder.asc(root.get("nome"))));
		adicionarRestricoesDePaginacao(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(turmaFilter));
	}

	private Predicate[] criarRestricoes(TurmaFilter turmaFilter, CriteriaBuilder builder, Root<Turma> root) {
		List<Predicate> predicates = new ArrayList<>();
		
		if (!ObjectUtils.isEmpty(turmaFilter.getNome())) {
			predicates.add(builder.like(
					builder.lower(root.get("nome")), "%" + turmaFilter.getNome().toLowerCase() + "%"));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
	private Long total(TurmaFilter turmaFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Turma> root = criteria.from(Turma.class);
		
		Predicate[] predicates = criarRestricoes(turmaFilter, builder, root);
		criteria.where(predicates);
		criteria.select(builder.count(root));
		
		return manager.createQuery(criteria).getSingleResult();
	}

	private void adicionarRestricoesDePaginacao(TypedQuery<Turma> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;
		
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalRegistrosPorPagina);
	}
	
}
