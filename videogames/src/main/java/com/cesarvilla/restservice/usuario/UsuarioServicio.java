package com.cesarvilla.restservice.usuario;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class UsuarioServicio {
	
	@Autowired
	private UsuarioDataRepository repo;
	
	public CollectionModel<EntityModel<UsuarioData>> listAll(){
		List<EntityModel<UsuarioData>> usuarios = repo.findAll().stream()
				.map(usuario -> EntityModel.of(usuario,WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UsuarioController.class).getUsuario(usuario.getId())).withSelfRel()
						))
				.collect(Collectors.toList());
		
		return CollectionModel.of(usuarios, WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UsuarioController.class).getUsuarios()).withSelfRel());
	}
	
	public Integer save(UsuarioData usuario) {
       return repo.save(usuario).getId();
    }
     
    public EntityModel<UsuarioData> get(Integer id) {
        UsuarioData us = repo.findById(id)
        		.orElseThrow(() -> new UsuarioNotFoundException(Integer.toUnsignedLong(id)));
        return EntityModel.of(us,
        		WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UsuarioController.class).getUsuario(id)).withSelfRel(),
        		WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UsuarioController.class).getUsuarios()).withRel("usuarios"));        		
    }
     
    public void delete(Integer id) {
        repo.deleteById(id);
    }

}
