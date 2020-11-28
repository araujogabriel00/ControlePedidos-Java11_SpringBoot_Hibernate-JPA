package com.example.controlepedidos.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.controlepedidos.entities.Usuario;

@RestController
@RequestMapping(value = "/usuarios")
public class RecursosUsuario {

	@GetMapping
	public ResponseEntity<Usuario> findAll() {
		Usuario u = new Usuario(1L, "Gabriel", "gabriel.araujos@sempreceu.com", "993783203", "93783203G");
		return ResponseEntity.ok().body(u);
	}

}
