/* ANOT
 * 
 * PODE ACONTECER DE IR UM 'ID' JA EXISTENTE NA BASE
 * PARA NÃO CONFLITAR, SERA RETORNADO AO USUÁRIO SOMENTE UM ID QUE NÃO EXISTA NA BASE DE DADOS
 * 
 * */

package controller;

import java.time.LocalDateTime;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dto.ShortenUrlRequest;
import dto.ShortenUrlResponse;
import entities.UrlEntitys;
import jakarta.servlet.http.HttpServletRequest;
import repository.UrlRepository;

@RestController
public class UrlController {

	@Autowired
	private final UrlRepository urlRepository;
	
	public UrlController(UrlRepository urlRepository) {
		this.urlRepository = urlRepository;
	}

	
	@SuppressWarnings("deprecation")
	@PostMapping(value = "/shorten-url")
	public ResponseEntity<ShortenUrlResponse> shortenUrl(@RequestBody ShortenUrlRequest request, HttpServletRequest servletRequest) {
		
		
		String id;
		do {
			id = RandomStringUtils.randomAlphanumeric(5, 10); //BIBLIOTECA APACHE COMMONS LANG3
		} while(urlRepository.existsById(id));
		
		
		urlRepository.save(new UrlEntitys(id, request.url(), LocalDateTime.now().plusMinutes(1)));
		
		var redirectUrl = servletRequest.getRequestURL().toString().replace("shorten-url", id);
		
		return ResponseEntity.ok(new ShortenUrlResponse(redirectUrl));
	}
	
}
