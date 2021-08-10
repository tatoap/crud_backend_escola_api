package com.teste.escola.token;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.escola.api.core.EscolaApiProperty;

@RestController
@RequestMapping("/tokens")
public class TokenResource {

	@Autowired
	private EscolaApiProperty escolaApiProperty;
	
	@DeleteMapping("/revoke")
	public void revoke(HttpServletRequest request, HttpServletResponse response) {
		Cookie cookie = new Cookie("refreshToken", null);
		cookie.setHttpOnly(true);
		cookie.setSecure(escolaApiProperty.getSeguranca().isEnableHttps());
		cookie.setPath(request.getContextPath() + "/oauth/token");
		cookie.setMaxAge(0);
		
		response.addCookie(cookie);
		response.setStatus(HttpStatus.NO_CONTENT.value());
	}
}
