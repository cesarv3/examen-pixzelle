package com.cesarvilla.restservice.usuario;

import java.util.ArrayList;
import java.util.List;

import com.cesarvilla.restservice.videojuego.JuegoData;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name= "usuario")
@JsonIgnoreProperties("hibernateLazyInitializer")
public class UsuarioData {
	public UsuarioData() {}
	public UsuarioData(Integer id, String nombre, String paterno, String materno, String correo, Integer rol) {
		this.id = id;
		this.nombre = nombre;
		this.paterno = paterno;
		this.materno = materno;
		this.correo = correo;
		this.rol = rol;
	}
	@Id
    @GeneratedValue
    @Column(name="usuario_id")
	@Getter @Setter private Integer id;	 
	
	@Getter @Setter private String nombre;
	@Getter @Setter private String paterno;
	@Getter @Setter private String materno;
	@Getter @Setter private String correo;
	@Getter @Setter private Integer rol;
	@Getter @Setter private Integer hasError = 0;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="usuarios_juegos",
	joinColumns=@JoinColumn(name="usuario_id"),
	inverseJoinColumns=@JoinColumn(name="juego_id"))
	@Getter @Setter private List<JuegoData> juegos = new ArrayList<>();
	
    
    
	
	// Overriding the toString method
    // to find all the values
    @Override
   public String toString()
    {
  
        return "Employee [id="
            + id + ", nombre="
            + nombre + ", paterno="
            + paterno + ", materno="
            + materno + ", correo="
            + correo + "]";
  
           
    }

}
