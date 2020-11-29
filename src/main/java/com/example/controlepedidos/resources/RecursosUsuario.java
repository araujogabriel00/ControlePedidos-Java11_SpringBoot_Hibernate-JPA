package com.example.controlepedidos.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

	@PostMapping
	public ResponseEntity<Usuario> insert(@RequestBody Usuario obj) {
		obj = servicos.insert(obj);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);

	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		servicos.delete(id);
		return ResponseEntity.noContent().build();
		
		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Usuario>update(@PathVariable Long id, @RequestBody Usuario obj){
		obj = servicos.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	
}
