package com.sueldos.liquidacion.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity(name="Convenio")
@Table(name="convenios")
public class Convenio {

	/*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idConvenio;
	private String nombreConvenio;
	private String categoria;*/
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idConvenio;
	private String numero;
	private String nombre;
	
	//@OneToMany(mappedBy = "convenio")
	//List<Categoria> categorias;
	
	@OneToMany(mappedBy = "convenio", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<Categoria> categorias = new ArrayList<>();
	
	
	public Convenio() {
		
	}


	public Convenio(Integer idConvenio, String numero, String nombre, List<Categoria> categorias) {
		super();
		this.idConvenio = idConvenio;
		this.numero = numero;
		this.nombre = nombre;
		this.categorias = categorias;
	}


	public Integer getIdConvenio() {
		return idConvenio;
	}


	public void setIdConvenio(Integer idConvenio) {
		this.idConvenio = idConvenio;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public List<Categoria> getCategorias() {
		return categorias;
	}


	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}


	
	
}
