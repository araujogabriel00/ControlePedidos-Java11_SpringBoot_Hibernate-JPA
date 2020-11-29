package com.example.controlepedidos.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.controlepedidos.servicousuario.Exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandartError> resourceNotFoundException(ResourceNotFoundException e,
			HttpServletRequest request) {
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandartError err = new StandartError(Instant.now(), status.value(), error, e.getMessage(),
				request.getRequestURI());

		return ResponseEntity.status(status).body(err);

	}

	@ExceptionHandler(DataBaseException.class)
	public ResponseEntity<StandartError> dataBaseException(DataBaseException e, HttpServletRequest request) {
		String error = "DataBase error";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandartError err = new StandartError(Instant.now(), status.value(), error, e.getMessage(),
				request.getRequestURI());

		return ResponseEntity.status(status).body(err);

	}

}
