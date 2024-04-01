package com.sueldos.liquidacion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity(name="Novedad")
@Table(name="novedades")
public class Novedad {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idNovedades;
	private int vacaciones;
	private int feriado;
	private int inasistenciaJustificada;
	private int inasistenciaInjustificada;
	
	@ManyToOne
	@JoinColumn(name = "colaborador_id")
	private Colaborador colaborador;
	
	public Novedad() {

	}

	public Novedad(Integer idNovedades, int vacaciones, int feriado, int inasistenciaJustificada,
			int inasistenciaInjustificada, Colaborador colaborador) {
		super();
		this.idNovedades = idNovedades;
		this.vacaciones = vacaciones;
		this.feriado = feriado;
		this.inasistenciaJustificada = inasistenciaJustificada;
		this.inasistenciaInjustificada = inasistenciaInjustificada;
		this.colaborador = colaborador;
	}

	public Integer getIdNovedades() {
		return idNovedades;
	}

	public void setIdNovedades(Integer idNovedades) {
		this.idNovedades = idNovedades;
	}

	public int getVacaciones() {
		return vacaciones;
	}

	public void setVacaciones(int vacaciones) {
		this.vacaciones = vacaciones;
	}

	public int getFeriado() {
		return feriado;
	}

	public void setFeriado(int feriado) {
		this.feriado = feriado;
	}

	public int getInasistenciaJustificada() {
		return inasistenciaJustificada;
	}

	public void setInasistenciaJustificada(int inasistenciaJustificada) {
		this.inasistenciaJustificada = inasistenciaJustificada;
	}

	public int getInasistenciaInjustificada() {
		return inasistenciaInjustificada;
	}

	public void setInasistenciaInjustificada(int inasistenciaInjustificada) {
		this.inasistenciaInjustificada = inasistenciaInjustificada;
	}

	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}


}
