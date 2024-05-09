package com.sueldos.liquidacion.service;

import java.util.List;

import com.sueldos.liquidacion.model.Colaborador;

public interface IColaboradorService {

	public void crear(Colaborador colaborador);
	public List<Colaborador>listar();
	public void borrar(Integer id);
    public Colaborador buscar(Integer id);
    public void actualizar(Colaborador colaborador);
    public Colaborador cambiarEstadoActivoColaborador(Integer id, Boolean nuevoEstado);
    public List<Colaborador> listarPorEstado(boolean activo);

}
