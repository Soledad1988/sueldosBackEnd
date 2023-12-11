package com.sueldos.liquidacion.model;

import java.util.ArrayList;
import java.util.Date;
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

@Entity(name="Colaborador")
@Table(name="colaboradores")
public class Colaborador {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String apellido;
	private String dni;
	private Date nacimiento;
	private Integer edad;
	private String direccion;
	private Boolean activo = true;
	
	@ManyToOne
	@JoinColumn(name = "id_convenio", nullable = false)
	private Convenio convenio;
	
	@ManyToOne
	@JoinColumn(name = "id_catgoria", nullable = false)
	private Categoria categoria;
	
	
	
	public Colaborador() {
	
	}



	public Colaborador(Integer id, String nombre, String apellido, String dni, Date nacimiento, Integer edad,
			String direccion, Boolean activo, Convenio convenio, Categoria categoria) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.nacimiento = nacimiento;
		this.edad = edad;
		this.direccion = direccion;
		this.activo = activo;
		this.convenio = convenio;
		this.categoria = categoria;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public String getDni() {
		return dni;
	}



	public void setDni(String dni) {
		this.dni = dni;
	}



	public Date getNacimiento() {
		return nacimiento;
	}



	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}



	public Integer getEdad() {
		return edad;
	}



	public void setEdad(Integer edad) {
		this.edad = edad;
	}



	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public Boolean getActivo() {
		return activo;
	}



	public void setActivo(Boolean activo) {
		this.activo = activo;
	}



	public Convenio getConvenio() {
		return convenio;
	}



	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}



	public Categoria getCategoria() {
		return categoria;
	}



	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	

	
	
}
