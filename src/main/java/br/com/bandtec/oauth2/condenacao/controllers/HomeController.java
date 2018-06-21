package br.com.bandtec.oauth2.condenacao.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

	@GetMapping
	public ResponseEntity home() {
		return ResponseEntity.ok("Apresentação Escritório de Projetos 4!");
	}
}
