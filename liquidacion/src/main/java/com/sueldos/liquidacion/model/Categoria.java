package com.sueldos.liquidacion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity(name="Categoria")
@Table(name="categorias")
public class Categoria {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCategoria;
	private String nombre;
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name = "id_convenio", nullable = false)
	private Convenio convenio;
	
	public Categoria() {
		
	}

	public Categoria(Integer idCategoria, String nombre, String descripcion, Convenio convenio) {
		super();
		this.idCategoria = idCategoria;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.convenio = convenio;
	}

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Convenio getConvenio() {
		return convenio;
	}

	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}

	
}
