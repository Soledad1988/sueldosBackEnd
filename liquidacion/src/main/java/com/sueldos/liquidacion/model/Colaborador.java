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
	private String cuit;
	private Date nacimiento;
	private Integer edad;
	private String direccion;
	private Date fecha_ingreso;
	private boolean activo;
	
	@ManyToOne
	@JoinColumn(name = "id_convenio", nullable = false)
	private Convenio convenio;
	
	@ManyToOne
	@JoinColumn(name = "id_catgoria", nullable = false)
	private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name = "id_obra_social", nullable = false)
	private ObraSocial obrasocial;
	
	@OneToMany(mappedBy = "colaborador", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Liquidacion> liquidaciones = new ArrayList<>();
	
	
	public Colaborador() {
	
	}

	
	public Colaborador(Integer id, String nombre, String apellido, String dni, String cuit, Date nacimiento,
			Integer edad, String direccion, Date fecha_ingreso, boolean activo, Convenio convenio, Categoria categoria,
			ObraSocial obrasocial, List<Liquidacion> liquidaciones) {
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
		this.convenio = convenio;
		this.categoria = categoria;
		this.obrasocial = obrasocial;
		this.liquidaciones = liquidaciones;
	}



	public ObraSocial getObraSocial() {
		return obrasocial;
	}


	public void setObraSocial(ObraSocial obrasocial) {
		this.obrasocial = obrasocial;
	}


	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Date getFecha_ingreso() {
		return fecha_ingreso;
	}

	public void setFecha_ingreso(Date fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
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

	public List<Liquidacion> getLiquidaciones() {
		return liquidaciones;
	}

	public void setLiquidaciones(List<Liquidacion> liquidaciones) {
		this.liquidaciones = liquidaciones;
	}


	//---------------------------------
	public void addLiquidacion(Liquidacion liquidacion) {
	        liquidaciones.add(liquidacion);
	        liquidacion.setColaborador(this);
	    }

	    public void removeLiquidacion(Liquidacion liquidacion) {
	        liquidaciones.remove(liquidacion);
	        liquidacion.setColaborador(null);
	    }
	
}
