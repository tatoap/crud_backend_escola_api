package com.teste.escola.api.core;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties("escola")
@Getter
@Setter
public class EscolaApiProperty {
	
	private String originPermitida = "http://localhost:8000";
	
	private final Seguranca seguranca = new Seguranca();
	
	@Getter
	@Setter
	public static class Seguranca {
		
		private boolean enableHttps;
		
	}

}
