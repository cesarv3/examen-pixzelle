package com.cesarvilla.restservice.usuario;

@SuppressWarnings("serial")
public class UsuarioNotFoundException extends RuntimeException{
	UsuarioNotFoundException(Long id){
		super("No se pudo encontrar el usuario: " + id);
	}

}
