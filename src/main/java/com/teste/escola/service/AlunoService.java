package com.teste.escola.service;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.teste.escola.exception.AlunoNaoEncontradoException;
import com.teste.escola.model.Aluno;
import com.teste.escola.model.Cidade;
import com.teste.escola.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private CidadeService cidadeService;
	
	@Transactional
	public Aluno salvar(Aluno aluno) {

		Cidade cidade = cidadeService.buscarOuFalhar(aluno.getEndereco().getCidade().getId());
		
		aluno.getEndereco().setCidade(cidade);
		
		return alunoRepository.save(aluno);
	}
	
	@Transactional
	public Aluno atualizar(Aluno aluno, Long alunoId) {
		Aluno alunoSalvo = buscarOuFalhar(alunoId);
		
		Cidade cidade = cidadeService.buscarOuFalhar(aluno.getEndereco().getCidade().getId());
		
		aluno.getEndereco().setCidade(cidade);
		
		BeanUtils.copyProperties(aluno, alunoSalvo, "id");
		
		return alunoRepository.save(alunoSalvo);
	}
	
	@Transactional
	public void excluir(Long alunoId) {
		try {
			alunoRepository.deleteById(alunoId);
			alunoRepository.flush();
		} catch (EmptyResultDataAccessException e) {
			throw new AlunoNaoEncontradoException(alunoId);
		} 
	}
	
	public Aluno buscarOuFalhar(Long alunoId) {
		return alunoRepository.findById(alunoId)
				.orElseThrow(() -> new AlunoNaoEncontradoException(alunoId));
	}

}
