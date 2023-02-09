package com.cesarvilla.restservice.videojuego;

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
public class JuegoServicio {
	@Autowired
	private JuegoDataRepository repo;
	
	public EntityModel<JuegoData> get(Integer id){
		JuegoData game = repo.findById(id)
				.orElseThrow(() -> new JuegoNotFoundException(Integer.toUnsignedLong(id)));
		return EntityModel.of(game,
				WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(JuegoController.class).getJuego(id)).withSelfRel(),
        		WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(JuegoController.class).getJuegos()).withRel("juegos"));
	}
	
	public CollectionModel<EntityModel<JuegoData>> listAll() {
		List<EntityModel<JuegoData>> juegos = repo.findAll().stream()
				.map(juego -> EntityModel.of(juego, WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(JuegoController.class)
						.getJuego(juego.getJuego_id())).withSelfRel()
						)).collect(Collectors.toList());
		return CollectionModel.of(juegos,
				WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(JuegoController.class).getJuegos()).withSelfRel());
	}
	
	public Integer save(JuegoData juego) {
		return repo.save(juego).getJuego_id();
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}

}
