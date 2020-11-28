package com.example.controlepedidos.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.controlepedidos.entities.Usuario;
import com.example.controlepedidos.repositories.RepositorioUsuario;

/// CLASSE DE CONFIGURAÇÃO
///QUANDO UM SERVIÇO DEPENDE DE OUTRO A DEPENDECIA DEVE SER FRACA

@Profile("test")
@Configuration

public class ConfigTest implements CommandLineRunner {

	@Autowired
	private RepositorioUsuario repositoriousuario;

	@Override
	public void run(String... args) throws Exception {

		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		repositoriousuario.saveAll(Arrays.asList(u1, u2));
	}

}
