package com.sueldos.liquidacion.model;

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
	private String cuit;
	private Date nacimiento;
	private Integer edad;
	private String direccion;
	private Date fecha_ingreso;
	private boolean activo;
	
	
	@ManyToOne
	@JoinColumn(name = "id_categoria", nullable = false)
	private Categoria categoria;
	
	@ManyToOne
    @JoinColumn(name = "id_obra_social")
    private ObraSocial obraSocial;

	
	
	public Colaborador() {
	
	}



	public Colaborador(Integer id, String nombre, String apellido, String dni, String cuit, Date nacimiento,
			Integer edad, String direccion, Date fecha_ingreso, boolean activo, Categoria categoria,
			ObraSocial obraSocial) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.cuit = cuit;
		this.nacimiento = nacimiento;
		this.edad = edad;
		this.direccion = direccion;
		this.fecha_ingreso = fecha_ingreso;
		this.activo = activo;
		this.categoria = categoria;
		this.obraSocial = obraSocial;
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



	public String getCuit() {
		return cuit;
	}



	public void setCuit(String cuit) {
		this.cuit = cuit;
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



	public Date getFecha_ingreso() {
		return fecha_ingreso;
	}



	public void setFecha_ingreso(Date fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}



	public boolean isActivo() {
		return activo;
	}



	public void setActivo(boolean activo) {
		this.activo = activo;
	}



	public Categoria getCategoria() {
		return categoria;
	}



	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}



	public ObraSocial getObraSocial() {
		return obraSocial;
	}



	public void setObraSocial(ObraSocial obraSocial) {
		this.obraSocial = obraSocial;
	}
	
}
	
