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
	private String numero;
	private String nombre;
	
	/*
	@OneToMany(mappedBy = "convenio", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<Categoria> categorias = new ArrayList<>();
	
	@OneToMany(mappedBy = "convenio", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<Colaborador> colaboradores = new ArrayList<>();*/
	
	
	
	public Convenio() {
		
	}


	public Convenio(Integer idConvenio, String numero, String nombre) {
		super();
		this.idConvenio = idConvenio;
		this.numero = numero;
		this.nombre = nombre;
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


	
	
}
