package com.sueldos.liquidacion.service;

import java.util.List;

import com.sueldos.liquidacion.model.Convenio;


public interface IConvenioService {

	public void crear(Convenio convenio);
	public List<Convenio>listar();
	public void borrar(Integer idConvenio);
    public Convenio buscar(Integer idConvenio);
    public void actualizar(Convenio convenio);
}
