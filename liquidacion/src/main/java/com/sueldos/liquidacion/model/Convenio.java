package com.sueldos.liquidacion.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity(name="Convenio")
@Table(name="convenios")
public class Convenio {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idConvenio;
	private String nombreConvenio;
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="convenio", cascade = CascadeType.ALL)
	@JsonIgnore
    private List<Categoria> categoria;
	
	
	public Convenio() {
		
	}


	public Convenio(Integer idConvenio, String nombreConvenio, List<Categoria> categoria) {
		super();
		this.idConvenio = idConvenio;
		this.nombreConvenio = nombreConvenio;
		this.categoria = categoria;
	}


	public Integer getIdConvenio() {
		return idConvenio;
	}


	public void setIdConvenio(Integer idConvenio) {
		this.idConvenio = idConvenio;
	}


	public String getNombreConvenio() {
		return nombreConvenio;
	}


	public void setNombreConvenio(String nombreConvenio) {
		this.nombreConvenio = nombreConvenio;
	}


	public List<Categoria> getCategoria() {
		return categoria;
	}


	public void setCategoria(List<Categoria> categoria) {
		this.categoria = categoria;
	}

	
}
