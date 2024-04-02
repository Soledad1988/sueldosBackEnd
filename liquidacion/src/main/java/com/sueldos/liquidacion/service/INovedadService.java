package com.sueldos.liquidacion.service;

import java.util.List;

import com.sueldos.liquidacion.model.Novedad;

public interface INovedadService {
	public void crear(Novedad novedad);
    public List<Novedad> listar();
    public void borrar(Integer idNovedad);
    public Novedad buscar(Integer idNovedad);
    public void actualizar(Novedad novedad);

}
