package com.teste.escola.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.teste.escola.exception.AlunoNaoEncontradoException;
import com.teste.escola.exception.NegocioException;
import com.teste.escola.exception.TurmaNaoEncontradaException;
import com.teste.escola.model.Aluno;
import com.teste.escola.repository.AlunoRepository;
import com.teste.escola.repository.filter.AlunoFilter;
import com.teste.escola.service.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoResource {

	@Autowired
	private AlunoService alunoService;
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_ALUNO') and hasAuthority('SCOPE_write')")
	public Page<Aluno> listar(AlunoFilter alunoFilter, Pageable pageable) {
		return alunoRepository.filtrar(alunoFilter, pageable);
	}
	
	@GetMapping("/{alunoId}")
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_ALUNO') and hasAuthority('SCOPE_write')")
	public Aluno buscar(@PathVariable Long alunoId) {
		return alunoService.buscarOuFalhar(alunoId);
	}
	
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_ALUNO') and hasAuthority('SCOPE_write')")
	public ResponseEntity<Aluno> salvar(@Valid @RequestBody Aluno aluno) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.salvar(aluno));
		} catch (TurmaNaoEncontradaException e) {
			throw new NegocioException(e.getMessage());
		}
		
	}
	
	@PutMapping("/{alunoId}")
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_TURMA') and hasAuthority('SCOPE_write')")
	public ResponseEntity<Aluno> atualizar(@Valid @RequestBody Aluno aluno, @PathVariable Long alunoId) {
		try {
			Aluno alunoSalvo = alunoService.buscarOuFalhar(alunoId);
			
			alunoSalvo = alunoService.atualizar(aluno, alunoId);
			
			return ResponseEntity.status(HttpStatus.OK).body(alunoSalvo);
		} catch (AlunoNaoEncontradoException | TurmaNaoEncontradaException e) {
			throw new NegocioException(e.getMessage());
		}
	}
	
	@DeleteMapping("/{alunoId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_TURMA') and hasAuthority('SCOPE_write')")
	public void remover(@PathVariable Long alunoId) {
		alunoService.excluir(alunoId);
	}
}
