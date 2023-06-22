package com.sueldos.liquidacion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name="Convenio")
@Table(name="convenios")
public class Convenio {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idConvenio;
	private String nombreConvenio;
	private String categoria;
	private Double basico;
	
	
	public Convenio() {
		
	}


	public Convenio(Integer idConvenio, String nombreConvenio, String categoria, Double basico) {
		super();
		this.idConvenio = idConvenio;
		this.nombreConvenio = nombreConvenio;
		this.categoria = categoria;
		this.basico = basico;
		}


	public Integer getIdConvenio() {
		return idConvenio;
	}


	public String getNombreConvenio() {
		return nombreConvenio;
	}


	public String getCategoria() {
		return categoria;
	}
	
	public Double getBasico() {
		return basico;
	}

	
	
}
