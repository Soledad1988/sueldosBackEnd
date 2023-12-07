package com.sueldos.liquidacion.service;

import java.util.List;

import com.sueldos.liquidacion.model.Categoria;

public interface ICategoriaService {

	    public void crear(Categoria categoria);
	    public List<Categoria> listar();
	    public void borrar(Integer idCategoria);
	    public Categoria buscar(Integer idCategoria);
	    public void actualizar(Categoria categoria);
}
