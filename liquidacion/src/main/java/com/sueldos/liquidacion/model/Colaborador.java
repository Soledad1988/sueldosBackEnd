package com.sueldos.liquidacion.model;

import java.util.Date;

import com.sueldos.liquidacion.controller.DatosColaborador;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	private String convenio;
	
	
	public Colaborador() {
	
	}

	public Colaborador(Integer id, String nombre, String apellido, String dni, Date nacimiento, Integer edad,
			String direccion, String convenio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.nacimiento = nacimiento;
		this.edad = edad;
		this.direccion = direccion;
		this.convenio = convenio;
	}

	public Colaborador(DatosColaborador datosColaborador) {
		this.nombre = datosColaborador.nombre();
		this.apellido = datosColaborador.apellido();
		this.dni = datosColaborador.dni();
		this.nacimiento = datosColaborador.nacimiento();
		this.edad = datosColaborador.edad();
		this.direccion = datosColaborador.direccion();
		this.convenio = datosColaborador.convenio();
	}

	public Integer getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getDni() {
		return dni;
	}

	public Date getNacimiento() {
		return nacimiento;
	}

	public Integer getEdad() {
		return edad;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getConvenio() {
		return convenio;
	}


	
}
