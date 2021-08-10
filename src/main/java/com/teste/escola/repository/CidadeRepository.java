package com.teste.escola.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.teste.escola.model.Cidade;

@Repository
public interface CidadeRepository extends CustomJpaRepository<Cidade, Long> {

	@Query("from Cidade where estado.id = :estadoId")
	List<Cidade> findByEstado(Long estadoId);
}
