package com.cesarvilla.restservice.consola;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ConsolaNoEncontradaAviso {
	@ResponseBody
	@ExceptionHandler(ConsolaNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String consolaNoEncotradaHandler(ConsolaNotFoundException e) {
		return e.getMessage();
	}

}
