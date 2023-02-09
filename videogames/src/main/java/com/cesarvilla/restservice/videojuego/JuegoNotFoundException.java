package com.cesarvilla.restservice.videojuego;

@SuppressWarnings("serial")
public class JuegoNotFoundException extends RuntimeException{
	JuegoNotFoundException(Long id){
		super("No se pudo encontrar el juego: " + id);
	}

}
