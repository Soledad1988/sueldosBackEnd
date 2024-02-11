package com.sueldos.liquidacion.service;

import java.util.List;

import com.sueldos.liquidacion.model.Colaborador;
import com.sueldos.liquidacion.model.Liquidacion;


public interface ILiquidacionService {

	void crear(Liquidacion liquidacion);
    List<Liquidacion> listar();
    void borrar(Liquidacion liquidacion);
    Liquidacion buscar(Integer idLiquidacion);
    void actualizar(Liquidacion liquidacion);
    void calcularLiquidacion(Colaborador colaborador, Liquidacion liquidacion);

}
