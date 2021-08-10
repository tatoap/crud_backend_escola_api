package com.teste.escola.api.assembler;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.teste.escola.api.model.AlunoResumoModel;
import com.teste.escola.model.Aluno;

@Component
public class AlunoModelAssembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public AlunoResumoModel toModel(Aluno aluno) {
		return modelMapper.map(aluno, AlunoResumoModel.class);
	}
	
	public List<AlunoResumoModel> toCollectionModel(Set<Aluno> alunos){
		return alunos.stream()
				.map(aluno -> toModel(aluno))
				.collect(Collectors.toList());
	}
	
}
