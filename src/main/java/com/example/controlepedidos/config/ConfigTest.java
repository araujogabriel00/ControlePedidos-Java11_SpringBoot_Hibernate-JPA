package com.example.controlepedidos.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.controlepedidos.entities.Pedidos;
import com.example.controlepedidos.entities.Usuario;
import com.example.controlepedidos.entities.enums.PedidoStatus;
import com.example.controlepedidos.repositories.RepositorioPedido;
import com.example.controlepedidos.repositories.RepositorioUsuario;

/// CLASSE DE CONFIGURAÇÃO
///QUANDO UM SERVIÇO DEPENDE DE OUTRO A DEPENDECIA DEVE SER FRACA

@Profile("test")
@Configuration

public class ConfigTest implements CommandLineRunner {

	@Autowired
	private RepositorioPedido repositoriopedido;

	@Autowired
	private RepositorioUsuario repositoriousuario;

	@Override
	public void run(String... args) throws Exception {

		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		Pedidos o1 = new Pedidos(null, Instant.parse("2019-06-20T19:53:07Z"), PedidoStatus.PAID, u1);
		Pedidos o2 = new Pedidos(null, Instant.parse("2019-07-21T03:42:10Z"), PedidoStatus.DELIVERED, u2);
		Pedidos o3 = new Pedidos(null, Instant.parse("2019-07-22T15:21:22Z"), PedidoStatus.SHIPPED, u1);

		repositoriousuario.saveAll(Arrays.asList(u1, u2));
		repositoriopedido.saveAll(Arrays.asList(o1, o2, o3));
	}

}
