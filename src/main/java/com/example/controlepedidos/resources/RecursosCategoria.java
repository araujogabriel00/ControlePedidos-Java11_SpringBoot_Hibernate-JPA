package com.example.controlepedidos.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.controlepedidos.entities.Categoria;
import com.example.controlepedidos.servicousuario.ServicoCategoria;

@RestController
@RequestMapping(value = "/categoria")
public class RecursosCategoria {

	@Autowired
	private ServicoCategoria servicos;

	@GetMapping
	public ResponseEntity<List<Categoria>> findAll() {

		List<Categoria> list = servicos.findAll();

		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Long id) {

		Categoria obj = servicos.findById(id);

		return ResponseEntity.ok().body(obj);
	}

}
