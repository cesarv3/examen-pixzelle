package com.cesarvilla.restservice.compania;

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
@RequestMapping(value= CompaniaController.ROOT_PATH)
public class CompaniaController {
	public static final String ROOT_PATH = "/compania";
	
	@Autowired
	private CompaniaServicio servicio;
	
	@GetMapping("/all")
	public CollectionModel<EntityModel<CompaniaData>> getCompanias() {
		return servicio.listAll();
	}
	
	@GetMapping("/{id}")
	public EntityModel<CompaniaData> getCompania(@PathVariable Integer id){
		return servicio.get(id);
	}
	
	@PostMapping("/create")
	public Integer createCompania(@RequestBody CompaniaData compania) {
		return servicio.save(compania);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		 servicio.delete(id);
	}
	
	@PutMapping("/{id}")
	public EntityModel<CompaniaData> update(@RequestBody CompaniaData compania, @PathVariable Integer id){
		try {
			EntityModel<CompaniaData> companiaEnc = servicio.get(id);
			
			companiaEnc.getContent().setNombre(compania.getNombre());
			servicio.save(companiaEnc.getContent());
			return companiaEnc;
		} catch(NoSuchElementException e) {
			return null;
		}
		
	}

}
