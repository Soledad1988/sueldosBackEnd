package com.sueldos.liquidacion.service;

import java.util.List;

import com.sueldos.liquidacion.model.Liquidacion;


public interface ILiquidacionService {

	public void crear(Liquidacion liquidacion);
	public List<Liquidacion>listar();
	public void borrar(Liquidacion idLiquidacion);
    public Liquidacion buscar(Integer idLiquidacion);
    public void actualizar(Liquidacion liquidacion);
}
