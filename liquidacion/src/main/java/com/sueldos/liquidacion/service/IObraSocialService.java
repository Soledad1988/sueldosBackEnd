package com.sueldos.liquidacion.service;

import java.util.List;

import com.sueldos.liquidacion.model.ObraSocial;

public interface IObraSocialService {

	 public void crear(ObraSocial obraSocial);
	    public List<ObraSocial> listar();
	    public void borrar(Integer idObraSocial);
	    public ObraSocial buscar(Integer idObraSocial);
	    public void actualizar(ObraSocial obraSocial);
	    public ObraSocial obtenerObraSocialPorId(Integer idObraSocial);
}
