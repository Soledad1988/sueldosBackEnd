package com.sueldos.liquidacion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name="Categoria")
@Table(name="categorias")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCategoria;
	private String nombre;
	private Double basico;
	
	public Categoria() {
		
	}
	
	public Categoria(Integer idCategoria, String nombre, Double basico) {
		super();
		this.idCategoria = idCategoria;
		this.nombre = nombre;
		this.basico = basico;
	}

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public String getNombre() {
		return nombre;
	}

	public Double getBasico() {
		return basico;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setBasico(Double basico) {
		this.basico = basico;
	}
	
	
	
}
