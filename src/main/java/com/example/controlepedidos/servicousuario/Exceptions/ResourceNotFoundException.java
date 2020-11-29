package com.example.controlepedidos.servicousuario.Exceptions;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(Object id) {
		super("ResourceNotFoundException . ID" + id);

	}

}
