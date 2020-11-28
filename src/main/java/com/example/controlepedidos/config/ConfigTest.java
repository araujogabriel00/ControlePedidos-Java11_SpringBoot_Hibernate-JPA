package com.example.controlepedidos.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.controlepedidos.entities.Categoria;
import com.example.controlepedidos.entities.Pedidos;
import com.example.controlepedidos.entities.Produtos;
import com.example.controlepedidos.entities.Usuario;
import com.example.controlepedidos.entities.enums.PedidoStatus;
import com.example.controlepedidos.repositories.RepositorioCategoria;
import com.example.controlepedidos.repositories.RepositorioPedido;
import com.example.controlepedidos.repositories.RepositorioProdutos;
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

	@Autowired
	private RepositorioCategoria repositoriocategoria;
	
	@Autowired
	private RepositorioProdutos repositorioprodutos ;
	

	

	@Override
	public void run(String... args) throws Exception {

		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		Pedidos o1 = new Pedidos(null, Instant.parse("2019-06-20T19:53:07Z"), PedidoStatus.PAID, u1);
		Pedidos o2 = new Pedidos(null, Instant.parse("2019-07-21T03:42:10Z"), PedidoStatus.DELIVERED, u2);
		Pedidos o3 = new Pedidos(null, Instant.parse("2019-07-22T15:21:22Z"), PedidoStatus.SHIPPED, u1);

		Categoria cat1 = new Categoria(null, "Electronics");
		Categoria cat2 = new Categoria(null, "Books");
		Categoria cat3 = new Categoria(null, "Computers");
		repositoriocategoria.saveAll(Arrays.asList(cat1, cat2, cat3));

		Produtos p1 = new Produtos(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Produtos p2 = new Produtos(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Produtos p3 = new Produtos(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Produtos p4 = new Produtos(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Produtos p5 = new Produtos(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

		repositoriousuario.saveAll(Arrays.asList(u1, u2));
		repositoriopedido.saveAll(Arrays.asList(o1, o2, o3));
		repositoriocategoria.saveAll(Arrays.asList(cat1, cat2, cat3));
		repositorioprodutos.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		

	}

}
