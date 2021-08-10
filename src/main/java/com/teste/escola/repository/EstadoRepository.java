package com.teste.escola.repository;

import org.springframework.stereotype.Repository;

import com.teste.escola.model.Estado;

@Repository
public interface EstadoRepository extends CustomJpaRepository<Estado, Long> {

}
