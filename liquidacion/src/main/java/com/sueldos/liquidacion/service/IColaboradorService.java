package com.sueldos.liquidacion.service;

import java.util.List;

import com.sueldos.liquidacion.model.Colaborador;

public interface IColaboradorService {

	public void crear(Colaborador colaborador);
	public List<Colaborador>listar();
}
