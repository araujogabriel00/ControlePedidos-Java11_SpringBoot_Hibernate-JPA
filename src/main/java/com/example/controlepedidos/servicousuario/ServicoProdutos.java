package com.example.controlepedidos.servicousuario;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.controlepedidos.entities.Produtos;
import com.example.controlepedidos.repositories.RepositorioProdutos;

@Component
public class ServicoProdutos {

	@Autowired
	private RepositorioProdutos repositorio;

	public List<Produtos> findAll() { /// BUSCAR TODOS OS USUARIOS
		return repositorio.findAll();
	}

	public Produtos findById(Long id) {

		Optional<Produtos> obj = repositorio.findById(id);
		return obj.get();

	}

}
