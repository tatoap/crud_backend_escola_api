package com.teste.escola.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.escola.model.Estado;
import com.teste.escola.repository.EstadoRepository;

@RestController
@RequestMapping("/estados")
public class EstadoResource {

	@Autowired
	private EstadoRepository estadoRepository;
	
	@GetMapping
	public List<Estado> listar() {
		return estadoRepository.findAll();
	}
}
