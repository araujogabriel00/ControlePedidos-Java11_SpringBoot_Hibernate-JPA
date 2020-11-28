package com.example.controlepedidos.servicousuario;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.controlepedidos.entities.Usuario;
import com.example.controlepedidos.repositories.RepositorioUsuario;

@Component
public class ServicoUsuario {

	@Autowired
	private RepositorioUsuario repositorio;

	public List<Usuario> findAll() { /// BUSCAR TODOS OS USUARIOS
		return repositorio.findAll();
	}

	public Usuario findById(Long id) {

		Optional<Usuario> obj = repositorio.findById(id);
		return obj.get();

	}

}
