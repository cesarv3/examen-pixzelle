package com.cesarvilla.restservice.consola;

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
@RequestMapping(value=ConsolaController.ROOT_PATH)
public class ConsolaController {
	public static final String ROOT_PATH = "/consola";
	
	@Autowired
	private ConsolaServicio servicio;
	
	@GetMapping("/all")
	public CollectionModel<EntityModel<ConsolaData>> getConsolas() {
		return servicio.listAll();
	}
	
	@GetMapping("/{id}")
	public EntityModel<ConsolaData> getConsola(@PathVariable Integer id) {
		return servicio.get(id);
	}
	
	@PostMapping("/create")
	public Integer createConsola(@RequestBody ConsolaData consola) {
		return servicio.save(consola);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		servicio.delete(id);
	}
	
	@PutMapping("/{id}")
	public EntityModel<ConsolaData> update(@RequestBody ConsolaData consola, @PathVariable Integer id){
		try {
			EntityModel<ConsolaData> consolaEnc = servicio.get(id);
			
			consolaEnc.getContent().setNombre(consola.getNombre());
			consolaEnc.getContent().setJuegos(consola.getJuegos());
			servicio.save(consolaEnc.getContent());
			return consolaEnc;
		}catch(NoSuchElementException e) {
			return null;
		}
	}

}
