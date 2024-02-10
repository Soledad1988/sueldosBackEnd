package com.sueldos.liquidacion.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity(name="Obrasocial")
@Table(name="obrasociales")
public class ObraSocial {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idObraSocial;
	private String nombre;
	private Integer codigo;
	
	@OneToMany(mappedBy = "obraSocial")
	@JsonIgnore
	private List<Colaborador> colaboradores;

	
	public ObraSocial() {

	}

	public ObraSocial(Integer idObraSocial, String nombre, Integer codigo, List<Colaborador> colaboradores) {
		super();
		this.idObraSocial = idObraSocial;
		this.nombre = nombre;
		this.codigo = codigo;
		this.colaboradores = colaboradores;
	}


	public List<Colaborador> getColaboradores() {
		return colaboradores;
	}

	public void setColaboradores(List<Colaborador> colaboradores) {
		this.colaboradores = colaboradores;
	}

	public Integer getIdObraSocial() {
		return idObraSocial;
	}

	public void setIdObraSocial(Integer idObraSocial) {
		this.idObraSocial = idObraSocial;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


	
}
