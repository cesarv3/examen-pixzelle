package com.cesarvilla.restservice.videojuego;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins ="*", allowedHeaders = "*")
@RequestMapping(value= JuegoController.ROOT_PATH)
public class JuegoController {
	public static final String ROOT_PATH = "/juego";
	
	@Autowired
	private JuegoServicio servicio;
	
	@GetMapping("/all")
	public CollectionModel<EntityModel<JuegoData>> getJuegos(){
		return servicio.listAll();
	}
	
	@GetMapping("/{id}")
	public EntityModel<JuegoData> getJuego(@PathVariable Integer id){
		return servicio.get(id);
	}
	
	@PostMapping("/create")
	public Integer createJuego(@RequestBody JuegoData juego) {
		return servicio.save(juego);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		servicio.delete(id);
	}
	
	@PutMapping("/{id}")
	public EntityModel<JuegoData> update(@RequestBody JuegoData juego, @PathVariable Integer id){
		try {
			EntityModel<JuegoData> juegoEnc = servicio.get(id);
			
			juegoEnc.getContent().setNombre(juego.getNombre());
			juegoEnc.getContent().setDescripcion(juego.getDescripcion());
			juegoEnc.getContent().setImagen(juego.getImagen());
			juegoEnc.getContent().setFechaLanzamiento(juego.getFechaLanzamiento());
			juegoEnc.getContent().setCompania(juego.getCompania());
			juegoEnc.getContent().setConsolas(juego.getConsolas());
			
			servicio.save(juegoEnc.getContent());
			return juegoEnc;
		}catch(NoSuchElementException e) {
			return null;
		}
	}

}
