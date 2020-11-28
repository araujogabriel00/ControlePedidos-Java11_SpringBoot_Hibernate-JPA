package com.example.controlepedidos.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.controlepedidos.entities.Usuario;
import com.example.controlepedidos.servicousuario.ServicoUsuario;

@RestController
@RequestMapping(value = "/usuarios")
public class RecursosUsuario {

	@Autowired
	private ServicoUsuario servicos;

	@GetMapping
	public ResponseEntity<List<Usuario>> findAll() {

		List<Usuario> list = servicos.findAll();

		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Long id) {

		Usuario obj = servicos.findById(id);

		return ResponseEntity.ok().body(obj);
	}

}
