package com.cesarvilla.restservice.videojuego;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cesarvilla.restservice.compania.CompaniaData;
import com.cesarvilla.restservice.consola.ConsolaData;
import com.cesarvilla.restservice.usuario.UsuarioData;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="juego")
public class JuegoData {
	@Id
	@GeneratedValue
	@Column(name="juego_id")
	@Getter @Setter private Integer juego_id;
	@Getter @Setter private String nombre;
	@Getter @Setter private String descripcion;
	@Getter @Setter private Date fechaLanzamiento;
	@Getter @Setter private String imagen;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="compania_id")
	@Getter @Setter private CompaniaData compania;
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="consolas_juegos",
	joinColumns=@JoinColumn(name="juego_id"),
	inverseJoinColumns=@JoinColumn(name="consola_id"))
	@Getter @Setter private List<ConsolaData> consolas = new ArrayList<>();
	
	@ManyToMany(mappedBy="juegos", fetch = FetchType.LAZY)
	@JsonIgnore
	@Getter @Setter private List<UsuarioData> usuarios = new ArrayList<>();
	
	public JuegoData(Integer juego_id, String nombre) {
		super();
		this.juego_id = juego_id;
		this.nombre = nombre;
		
	}
	
	public JuegoData() {
		super();
	}

}
