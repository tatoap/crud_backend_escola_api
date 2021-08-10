package com.teste.escola.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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

import com.teste.escola.api.assembler.AlunoModelAssembler;
import com.teste.escola.api.model.AlunoResumoModel;
import com.teste.escola.model.Turma;
import com.teste.escola.repository.TurmaRepository;
import com.teste.escola.repository.filter.TurmaFilter;
import com.teste.escola.service.TurmaService;

@RestController
@RequestMapping("/turmas")
public class TurmaResource {

	@Autowired
	private TurmaService turmaService;
	
	@Autowired
	private TurmaRepository turmaRepository;
	
	@Autowired
	private AlunoModelAssembler alunoModelAssembler;
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_TURMA') and hasAuthority('SCOPE_write')")
	public Page<Turma> listar(TurmaFilter turmaFilter, Pageable pageable) {
		return turmaRepository.filtrar(turmaFilter, pageable);
	}
	
	@GetMapping("/{turmaId}")
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_TURMA') and hasAuthority('SCOPE_write')")
	public Turma buscar(@PathVariable Long turmaId) {
		return turmaService.buscarOuFalhar(turmaId);
	}
	
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_TURMA') and hasAuthority('SCOPE_write')")
	public Turma salvar(@Valid @RequestBody Turma turma) {
		return turmaService.salvar(turma);
	}
	
	@PutMapping("/{turmaId}")
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_TURMA') and hasAuthority('SCOPE_write')")
	public Turma atualizar(@Valid @RequestBody Turma turma, @PathVariable Long turmaId) {
		Turma turmaSalva = turmaService.atualizar(turma, turmaId);
		return turmaSalva;
	}
	
	@DeleteMapping("/{turmaId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_TURMA') and hasAuthority('SCOPE_write')")
	public void remover(@PathVariable Long turmaId) {
		turmaService.buscarOuFalhar(turmaId);
		turmaService.excluir(turmaId);
	}
	
	@GetMapping("/{turmaId}/alunos")
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_TURMA') and hasAuthority('SCOPE_write')")
	public List<AlunoResumoModel> alunosPorTurma(@PathVariable Long turmaId) {
		Turma turma = turmaService.buscarOuFalhar(turmaId); 
		
		return alunoModelAssembler.toCollectionModel(turma.getAlunos());
	}
}
