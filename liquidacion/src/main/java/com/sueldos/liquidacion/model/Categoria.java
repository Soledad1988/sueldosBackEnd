package com.sueldos.liquidacion.model;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
	private Double basico;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="Id_Convenio")
	@JsonIgnore
	private Convenio convenio;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="categoria", cascade = CascadeType.ALL)
	private List<Colaborador> colaborador;
	
	
	public Categoria() {
		
	}


	public Categoria(Integer idCategoria, String nombre, Double basico, Convenio convenio,
			List<Colaborador> colaborador) {
		super();
		this.idCategoria = idCategoria;
		this.nombre = nombre;
		this.basico = basico;
		this.convenio = convenio;
		this.colaborador = colaborador;
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


	public Double getBasico() {
		return basico;
	}


	public void setBasico(Double basico) {
		this.basico = basico;
	}


	public Convenio getConvenio() {
		return convenio;
	}


	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}


	public List<Colaborador> getColaborador() {
		return colaborador;
	}


	public void setColaborador(List<Colaborador> colaborador) {
		this.colaborador = colaborador;
	}


	
}
