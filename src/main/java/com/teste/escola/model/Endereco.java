package com.teste.escola.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Endereco {
	
	@NotBlank
	@Column(name = "endereco_logradouro")
	private String logradouro;
	
	@NotBlank
	@Column(name = "endereco_numero")
	private String numero;
	
	@Column(name = "endereco_complemento")
	private String complemento;
	
	@NotBlank
	@Column(name = "endereco_bairro")
	private String bairro;
	
	@NotBlank
	@Column(name = "endereco_cep")
	private String cep;
	
	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "endereco_id_cidade")
	private Cidade cidade;

}
