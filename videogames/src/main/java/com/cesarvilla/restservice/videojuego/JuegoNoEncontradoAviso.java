package com.cesarvilla.restservice.videojuego;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class JuegoNoEncontradoAviso {
	@ResponseBody
	@ExceptionHandler(JuegoNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String juegoNotFoundHandler(JuegoNotFoundException ex) {
		return ex.getMessage();
	}

}
