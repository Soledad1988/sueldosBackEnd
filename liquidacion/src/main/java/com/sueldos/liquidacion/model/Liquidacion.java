package com.sueldos.liquidacion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity(name="Liquidacion")
@Table(name="liquidaciones")
public class Liquidacion {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLiquidacion;
    private double sueldoBasico;
    private double tiempo;
    private double otros;
    private double sueldoBruto;
    private double sueldoNeto;

    private static final double PRESENTISMO = 8.33 / 100;
    private static final double DESCUENTO_ANTIGUEDAD = 0.11 / 100;
    private static final double DESCUENTO_LEY = 0.3 / 100;
    private static final double DESCUENTO_OBRA_SOCIAL = 0.3 / 100;
	
	public Liquidacion() {
		
	}
	
	
	public Liquidacion(Integer idLiquidacion, double sueldoBasico, double tiempo, double otros, double 	sueldoBruto, double sueldoNeto) {
		super();
		this.idLiquidacion = idLiquidacion;
		this.sueldoBasico = sueldoBasico;
		this.tiempo = tiempo;
		this.otros = otros;
		this.sueldoBruto = sueldoBruto;
		this.sueldoNeto = sueldoNeto;
	}

	public Integer getIdLiquidacion() {
		return idLiquidacion;
	}


	public void setIdLiquidacion(Integer idLiquidacion) {
		this.idLiquidacion = idLiquidacion;
	}


	public double getSueldoBasico() {
		return sueldoBasico;
	}


	public void setSueldoBasico(double sueldoBasico) {
		this.sueldoBasico = sueldoBasico;
	}


	public double getTiempo() {
		return tiempo;
	}


	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}


	public double getOtros() {
		return otros;
	}


	public void setOtros(double otros) {
		this.otros = otros;
	}


	public double getSueldoBruto() {
		return sueldoBruto;
	}


	public void setSueldoBruto(double sueldoBruto) {
		this.sueldoBruto = sueldoBruto;
	}


	public double getSueldoNeto() {
		return sueldoNeto;
	}


	public void setSueldoNeto(double sueldoNeto) {
		this.sueldoNeto = sueldoNeto;
	}


	public static double getPresentismo() {
		return PRESENTISMO;
	}


	public static double getDescuentoAntiguedad() {
		return DESCUENTO_ANTIGUEDAD;
	}


	public static double getDescuentoLey() {
		return DESCUENTO_LEY;
	}


	public static double getDescuentoObraSocial() {
		return DESCUENTO_OBRA_SOCIAL;
	}


	//pruebas 
    public void calcularValores() {
    	// calcular sueldoBruto
        this.sueldoBruto = this.sueldoBasico + calcularAntiguedad() + (this.sueldoBasico * PRESENTISMO) +  		otros;

        // Cálculo de los descuentos
        double descuentoAntiguedad = this.sueldoBruto * DESCUENTO_ANTIGUEDAD;
        double descuentoLey = this.sueldoBruto * DESCUENTO_LEY;
        double descuentoObraSocial = this.sueldoBruto * DESCUENTO_OBRA_SOCIAL;

        // Cálculo del sueldo neto
        this.sueldoNeto = this.sueldoBruto - (descuentoAntiguedad + descuentoLey + descuentoObraSocial);

    }
    
    // Método para calcular la antigüedad
    public double calcularAntiguedad() {
        double factorAntiguedad = 0.01; // 1% por año, por ejemplo
        return sueldoBasico * tiempo * factorAntiguedad;
    }

	
}
