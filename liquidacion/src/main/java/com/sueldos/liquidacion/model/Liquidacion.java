package com.sueldos.liquidacion.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity(name="Liquidacion")
@Table(name="liquidaciones")
public class Liquidacion {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLiquidacion;
	private Date fecha;
    private double antiguedad;
    private double otros;
    private double descuentoAntiguedad;
    private double descuentoLey;
    private double descuentoObraSocial;
    protected double sueldoBruto;
    protected double sueldoNeto;

    private static final double DESCUENTO_ANTIGUEDAD = 0.11 / 100;
    private static final double DESCUENTO_LEY = 0.3 / 100;
    private static final double DESCUENTO_OBRA_SOCIAL = 0.3 / 100;
    
    @ManyToOne
    @JoinColumn(name = "id_colaborador", nullable = false)
    private Colaborador colaborador;
	
	public Liquidacion() {
		
	}

	public Liquidacion(Integer idLiquidacion, Date fecha, double antiguedad, double otros, double descuentoAntiguedad,
			double descuentoLey, double descuentoObraSocial, double sueldoBruto, double sueldoNeto,
			Colaborador colaborador) {
		super();
		this.idLiquidacion = idLiquidacion;
		this.fecha = fecha;
		this.antiguedad = antiguedad;
		this.otros = otros;
		this.descuentoAntiguedad = descuentoAntiguedad;
		this.descuentoLey = descuentoLey;
		this.descuentoObraSocial = descuentoObraSocial;
		this.sueldoBruto = sueldoBruto;
		this.sueldoNeto = sueldoNeto;
		this.colaborador = colaborador;
	}


	public void setDescuentoAntiguedad(double descuentoAntiguedad) {
		this.descuentoAntiguedad = descuentoAntiguedad;
	}

	public void setDescuentoLey(double descuentoLey) {
		this.descuentoLey = descuentoLey;
	}

	public void setDescuentoObraSocial(double descuentoObraSocial) {
		this.descuentoObraSocial = descuentoObraSocial;
	}

	public Integer getIdLiquidacion() {
		return idLiquidacion;
	}


	public void setIdLiquidacion(Integer idLiquidacion) {
		this.idLiquidacion = idLiquidacion;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public double getAntiguedad() {
		return antiguedad;
	}


	public void setAntiguedad(double tiempo) {
		this.antiguedad = tiempo;
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


	public Colaborador getColaborador() {
		return colaborador;
	}


	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
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

    // Método para calcular la antigüedad
    public double calcularAntiguedad() {
        double factorAntiguedad = 0.01; // 1% por año, por ejemplo
        return colaborador.getCategoria().getSueldoBasico() * antiguedad * factorAntiguedad;
    }
    
	//pruebas 
    public void calcularValores() {
        // Calcular sueldo bruto
        double sueldoBasicoCategoria = colaborador.getCategoria().getSueldoBasico();
        this.sueldoBruto = sueldoBasicoCategoria + calcularAntiguedad() + otros;

        // Calcular descuentos
        double descuentoAntiguedad = this.sueldoBruto * DESCUENTO_ANTIGUEDAD;
        double descuentoLey = this.sueldoBruto * DESCUENTO_LEY;
        double descuentoObraSocial = this.sueldoBruto * DESCUENTO_OBRA_SOCIAL;

        // Establecer los valores de los descuentos
        this.descuentoAntiguedad = descuentoAntiguedad;
        this.descuentoLey = descuentoLey;
        this.descuentoObraSocial = descuentoObraSocial;
        
        // Calcular sueldo neto
        this.sueldoNeto = this.sueldoBruto - (descuentoAntiguedad + descuentoLey + descuentoObraSocial);
    }

	
}
