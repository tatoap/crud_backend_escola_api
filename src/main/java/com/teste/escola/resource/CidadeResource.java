package com.teste.escola.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teste.escola.model.Cidade;
import com.teste.escola.repository.CidadeRepository;
import com.teste.escola.service.EstadoService;

@RestController
@RequestMapping("/cidades")
public class CidadeResource {

	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoService estadoService;
	
	@GetMapping
	public List<Cidade> listar(@RequestParam Long estadoId) {
		estadoService.buscarOuFalhar(estadoId);
		
		return cidadeRepository.findByEstado(estadoId);
	}
}
