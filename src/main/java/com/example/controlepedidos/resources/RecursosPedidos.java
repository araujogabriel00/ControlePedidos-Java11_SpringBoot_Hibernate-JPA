package com.example.controlepedidos.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.controlepedidos.entities.Pedidos;
import com.example.controlepedidos.servicousuario.ServicoPedido;

@RestController
@RequestMapping(value = "/pedidos")
public class RecursosPedidos {

	@Autowired
	private ServicoPedido servicos;

	@GetMapping
	public ResponseEntity<List<Pedidos>> findAll() {

		List<Pedidos> list = servicos.findAll();

		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Pedidos> findById(@PathVariable Long id) {

		Pedidos obj = servicos.findById(id);

		return ResponseEntity.ok().body(obj);
	}

}
