package com.teste.escola.repository.aluno;

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

import com.teste.escola.model.Aluno;
import com.teste.escola.repository.filter.AlunoFilter;

public class AlunoRepositoryImpl implements AlunoRepositoryQuery {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<Aluno> filtrar(AlunoFilter alunoFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Aluno> criteria = builder.createQuery(Aluno.class);
		Root<Aluno> root = criteria.from(Aluno.class);
		
		Predicate[] predicates = criarRestricoes(alunoFilter, builder, root);
		
		criteria.where(predicates);
		
		TypedQuery<Aluno> query = manager.createQuery(criteria.orderBy(builder.asc(root.get("nome"))));
		adicionarRestricoesDePaginacao(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(alunoFilter));
	}

	private Predicate[] criarRestricoes(AlunoFilter alunoFilter, CriteriaBuilder builder, Root<Aluno> root) {
		List<Predicate> predicates = new ArrayList<>();
		
		if (!ObjectUtils.isEmpty(alunoFilter.getNome())) {
			predicates.add(builder.like(builder.lower(root.get("nome")), "%" + alunoFilter.getNome().toLowerCase() + "%"));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
	private Long total(AlunoFilter alunoFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Aluno> root = criteria.from(Aluno.class);
		
		Predicate[] predicates = criarRestricoes(alunoFilter, builder, root);
		criteria.where(predicates);
		criteria.select(builder.count(root));
		
		return manager.createQuery(criteria).getSingleResult();
	}

	private void adicionarRestricoesDePaginacao(TypedQuery<Aluno> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;
		
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalRegistrosPorPagina);
	}
}
