package com.example.controlepedidos.servicousuario;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.controlepedidos.entities.Pedidos;
import com.example.controlepedidos.repositories.RepositorioPedido;

@Component
public class ServicoPedido {

	@Autowired
	private RepositorioPedido repositorio;

	public List<Pedidos> findAll() { /// BUSCAR TODOS OS USUARIOS
		return repositorio.findAll();
	}

	public Pedidos findById(Long id) {

		Optional<Pedidos> obj = repositorio.findById(id);
		return obj.get();

	}

}
