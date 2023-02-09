package com.cesarvilla.restservice.compania;

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
public class CompaniaServicio {
	@Autowired
	private CompaniaDataRepository repo;
	
	public CollectionModel<EntityModel<CompaniaData>> listAll() {
		List<EntityModel<CompaniaData>> companias = repo.findAll().stream()
				.map(compania -> EntityModel.of(compania, WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CompaniaController.class)
						.getCompania(compania.getCompania_id())).withSelfRel()
						)).collect(Collectors.toList());
				
		
		return CollectionModel.of(companias, WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CompaniaController.class).getCompanias()).withSelfRel());
	}
	
	public EntityModel<CompaniaData> get(Integer id){
		CompaniaData comp = repo.findById(id)
				.orElseThrow(() -> new CompaniaNotFoundException(Integer.toUnsignedLong(id)));
		return EntityModel.of(comp,
				WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CompaniaController.class).getCompania(id)).withSelfRel(),
        		WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CompaniaController.class).getCompanias()).withRel("companias"));
	}
	
	public Integer save(CompaniaData compania) {
		return repo.save(compania).getCompania_id();
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
}
