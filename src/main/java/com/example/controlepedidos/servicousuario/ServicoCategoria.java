package com.example.controlepedidos.servicousuario;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.controlepedidos.entities.Categoria;
import com.example.controlepedidos.repositories.RepositorioCategoria;

@Component
public class ServicoCategoria {

	@Autowired
	private RepositorioCategoria repositorio;

	public List<Categoria> findAll() { /// BUSCAR TODOS OS USUARIOS
		return repositorio.findAll();
	}

	public Categoria findById(Long id) {

		Optional<Categoria> obj = repositorio.findById(id);
		return obj.get();

	}

}
