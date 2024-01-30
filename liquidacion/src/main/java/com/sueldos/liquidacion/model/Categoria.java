package com.sueldos.liquidacion.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity(name="Categoria")
@Table(name="categorias")
public class Categoria {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCategoria;
	private String nombre;
	private double sueldoBasico;
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name = "id_convenio", nullable = false)
	private Convenio convenio;
	
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<Colaborador> colaboradores = new ArrayList<>();
	
	
	public Categoria() {
		
	}


	public Categoria(Integer idCategoria, String nombre, double sueldoBasico, String descripcion, Convenio convenio,
			List<Colaborador> colaboradores) {
		super();
		this.idCategoria = idCategoria;
		this.nombre = nombre;
		this.sueldoBasico = sueldoBasico;
		this.descripcion = descripcion;
		this.convenio = convenio;
		this.colaboradores = colaboradores;
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


	public double getSueldoBasico() {
		return sueldoBasico;
	}


	public void setSueldoBasico(double sueldoBasico) {
		this.sueldoBasico = sueldoBasico;
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


	public List<Colaborador> getColaboradores() {
		return colaboradores;
	}


	public void setColaboradores(List<Colaborador> colaboradores) {
		this.colaboradores = colaboradores;
	}

}
