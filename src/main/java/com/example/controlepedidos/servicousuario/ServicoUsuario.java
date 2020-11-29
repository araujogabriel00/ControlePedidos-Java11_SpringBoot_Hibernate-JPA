package com.example.controlepedidos.servicousuario;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import com.example.controlepedidos.entities.Usuario;
import com.example.controlepedidos.repositories.RepositorioUsuario;
import com.example.controlepedidos.resources.exceptions.DataBaseException;
import com.example.controlepedidos.servicousuario.Exceptions.ResourceNotFoundException;

@Component
public class ServicoUsuario {

	@Autowired
	private RepositorioUsuario repositorio;

	public List<Usuario> findAll() { /// BUSCAR TODOS OS USUARIOS
		return repositorio.findAll();
	}

	public Usuario findById(Long id) {

		Optional<Usuario> obj = repositorio.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));

	}

	public Usuario insert(Usuario obj) {
		return repositorio.save(obj);

	}

	public void delete(Long id) {

		try {
			repositorio.deleteById(id);

		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);

		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
	}

	public Usuario update(Long id, Usuario obj) {
		Usuario entidade = repositorio.getOne(id);
		atualizacaoDados(entidade, obj);
		return repositorio.save(entidade);

	}

	private void atualizacaoDados(Usuario entidade, Usuario obj) {
		entidade.setNome(obj.getNome());
		entidade.setEmail(obj.getEmail());
		entidade.setTelefone(obj.getTelefone());

	}

}
