package com.cesarvilla.restservice.compania;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CompaniaNoEncontradaAviso {
	@ResponseBody
	@ExceptionHandler(CompaniaNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String companiaNoEncontradaHandler(CompaniaNotFoundException ex) {
		return ex.getMessage();
	}

}
