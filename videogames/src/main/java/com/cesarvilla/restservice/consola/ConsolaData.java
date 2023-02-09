package com.cesarvilla.restservice.consola;


import java.util.ArrayList;
import java.util.List;

import com.cesarvilla.restservice.videojuego.JuegoData;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name=" consola")
@JsonIgnoreProperties("hibernateLazyInitializer")
public class ConsolaData {
	@Id
	@GeneratedValue
	@Column(name="consola_id")
	@Getter @Setter private Integer consola_id;	
	@Getter @Setter private String nombre;
	
	@ManyToMany(mappedBy="consolas")
	@JsonIgnore
	@Getter @Setter private List<JuegoData> juegos = new ArrayList<>();
	public ConsolaData() {}
	public ConsolaData(Integer id, String nombre) {
		super();
		this.consola_id = id;
		this.nombre = nombre;		
	}

	

}
