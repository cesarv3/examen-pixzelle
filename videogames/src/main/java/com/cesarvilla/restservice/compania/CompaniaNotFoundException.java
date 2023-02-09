package com.cesarvilla.restservice.compania;

@SuppressWarnings("serial")
public class CompaniaNotFoundException extends RuntimeException{
	CompaniaNotFoundException(Long id){
		super("No se pudo encontrar la compania: " + id);
	}

}
