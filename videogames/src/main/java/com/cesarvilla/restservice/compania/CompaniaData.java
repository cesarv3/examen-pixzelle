package com.cesarvilla.restservice.compania;

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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="compania")
@JsonIgnoreProperties("hibernateLazyInitializer")
public class CompaniaData {
	@Id
	@GeneratedValue
	@Column(name="compania_id")
	@Getter @Setter private Integer compania_id;
	@Getter @Setter private String nombre;
	
	@OneToMany(mappedBy = "compania")
	@JsonIgnore
	@Getter @Setter private List<JuegoData> juegos = new ArrayList<>();
	public CompaniaData() {}
	
	public String toString() {
		return "id: " + compania_id + " - " + nombre;
	}

}
