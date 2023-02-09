package com.cesarvilla.restservice.usuario;

import java.util.List;
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
@RequestMapping(value = UsuarioController.ROOT_PATH)
public class UsuarioController {
	public static final String ROOT_PATH = "/usuario";
	@Autowired
	private UsuarioServicio servicio;
	
	@PostMapping("/create")
	public Integer createUsuario(@RequestBody UsuarioData usuarioData) {
		return servicio.save(usuarioData);
	}
	
	@GetMapping("/all")
	public CollectionModel<EntityModel<UsuarioData>> getUsuarios() {
		return servicio.listAll();
	}
	@GetMapping("/{id}")
	public EntityModel<UsuarioData> getUsuario(@PathVariable Integer id) {
		return servicio.get(id);
	}
	
	@PutMapping("/{id}")
	public EntityModel<UsuarioData> update(@RequestBody UsuarioData usuario, @PathVariable Integer id) {
		try {
			EntityModel<UsuarioData> user = servicio.get(id);
			
			user.getContent().setCorreo(usuario.getCorreo());
			user.getContent().setNombre(usuario.getNombre());
			user.getContent().setPaterno(usuario.getPaterno());
			user.getContent().setMaterno(usuario.getMaterno());
			user.getContent().setRol(usuario.getRol());
			user.getContent().setHasError(usuario.getHasError());
			servicio.save(user.getContent());
			return user;
		}catch(NoSuchElementException e) {			
			return null;
		}
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		servicio.delete(id);
	}
}
