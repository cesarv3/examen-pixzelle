package com.cesarvilla.restservice.consola;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class ConsolaServicio {
	@Autowired
	private ConsolaDataRepository repo;
	public CollectionModel<EntityModel<ConsolaData>> listAll() {
		List<EntityModel<ConsolaData>> consolas = repo.findAll().stream()
				.map(consola -> EntityModel.of(consola, 
						WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ConsolaController.class)
								.getConsola(consola.getConsola_id())).withSelfRel()
						)).collect(Collectors.toList());
		return CollectionModel.of(consolas, WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ConsolaController.class).getConsolas()).withSelfRel());
	}
	
	public EntityModel<ConsolaData> get(Integer id) {
		ConsolaData cons = repo.findById(id)
				.orElseThrow(() -> new ConsolaNotFoundException(Integer.toUnsignedLong(id)));
		return EntityModel.of(cons,
				WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ConsolaController.class).getConsola(id)).withSelfRel(),
        		WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ConsolaController.class).getConsolas()).withRel("consolas"));
	}
	public Integer save(ConsolaData consola) {
		return repo.save(consola).getConsola_id();
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
}
