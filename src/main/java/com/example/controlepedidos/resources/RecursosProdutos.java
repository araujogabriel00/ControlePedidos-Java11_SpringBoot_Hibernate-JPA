package com.example.controlepedidos.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.controlepedidos.entities.Produtos;
import com.example.controlepedidos.servicousuario.ServicoProdutos;

@RestController
@RequestMapping(value = "/produtos")
public class RecursosProdutos {

	@Autowired
	private ServicoProdutos servicos;

	@GetMapping
	public ResponseEntity<List<Produtos>> findAll() {

		List<Produtos> list = servicos.findAll();

		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Produtos> findById(@PathVariable Long id) {

		Produtos obj = servicos.findById(id);

		return ResponseEntity.ok().body(obj);
	}

}
