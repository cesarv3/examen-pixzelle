package com.cesarvilla.restservice.consola;

@SuppressWarnings("serial")
public class ConsolaNotFoundException extends RuntimeException{
	ConsolaNotFoundException(Long id){
		super("No se pudo encontrar la consola: " + id);
	}

}
