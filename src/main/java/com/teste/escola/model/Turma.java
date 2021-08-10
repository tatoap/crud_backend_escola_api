package com.teste.escola.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.teste.escola.api.core.validation.Groups;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "turma")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Turma {
	
	@Id
	@NotNull(groups = Groups.TurmaId.class)
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(nullable = false)
	private String nome;
	
	@NotBlank
	@Column(nullable = false)
	private String instrutor;
	
	@NotNull
	@Column(name = "carga_horaria", nullable = false)
	private Integer cargaHoraria;
	
	//@OneToMany(mappedBy = "turma")
	@ManyToMany
	@JoinTable(name = "turma_aluno", 
	joinColumns = @JoinColumn(name = "turma_id"),
	inverseJoinColumns = @JoinColumn(name = "aluno_id"))
	private Set<Aluno> alunos = new HashSet<>();
	
	public boolean adicionarAluno(Aluno aluno) {
		return getAlunos().add(aluno);
	}

}
