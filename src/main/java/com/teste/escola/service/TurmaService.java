package com.teste.escola.service;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.teste.escola.exception.TurmaNaoEncontradaException;
import com.teste.escola.model.Aluno;
import com.teste.escola.model.Turma;
import com.teste.escola.repository.TurmaRepository;

@Service
public class TurmaService {
	
	@Autowired
	private TurmaRepository turmaRepository;
	
	@Autowired
	private AlunoService alunoService;
	
	@Transactional
	public Turma salvar(Turma turma) {
		if (turma.getAlunos() != null) {
			//turma.getAlunos().forEach(a -> a.setTurma(turma));
			turma.getAlunos().forEach(a -> turma.adicionarAluno(a));
		}
		return turmaRepository.save(turma);
	}
	
	@Transactional
	public void adicionarAluno(Long turmaId, Long alunoId) {
		Turma turma = buscarOuFalhar(turmaId);
		Aluno aluno = alunoService.buscarOuFalhar(alunoId);
		turma.adicionarAluno(aluno);
	}
	
	@Transactional
	public void excluir(Long turmaId) {
		try {
			turmaRepository.deleteById(turmaId);
			turmaRepository.flush();
		} catch (EmptyResultDataAccessException e) {
			throw new TurmaNaoEncontradaException(turmaId);
		} 
	}
	
	@Transactional
	public Turma atualizar(Turma turma, Long turmaId) {
		Turma turmaSalva = buscarOuFalhar(turmaId);
		
		turmaSalva.getAlunos().clear();
		turmaSalva.getAlunos().addAll(turma.getAlunos());
		turmaSalva.getAlunos().forEach(a -> System.out.println(a.getId() + " " + a.getNome()));
		turmaSalva.getAlunos().forEach(a -> turmaSalva.adicionarAluno(a));
				
		BeanUtils.copyProperties(turma, turmaSalva, "id", "alunos");
		
		return turmaRepository.save(turmaSalva);
	}
	
	public Turma buscarOuFalhar(Long turmaId) {		
		return turmaRepository.findById(turmaId)
				.orElseThrow(() -> new TurmaNaoEncontradaException(turmaId));
	}

}
