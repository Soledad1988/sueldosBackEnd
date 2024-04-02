package com.sueldos.liquidacion.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sueldos.liquidacion.model.Novedad;
import com.sueldos.liquidacion.repository.NovedadRepository;

@Service
public class NovedadService implements INovedadService{
	
	@Autowired
	private NovedadRepository novedadRepository;

	@Override
	public void crear(Novedad novedad) {
		novedadRepository.save(novedad);
		
	}

	@Override
	public List<Novedad> listar() {
		return novedadRepository.findAll();
	}

	@Override
	public void borrar(Integer idNovedad) {
		novedadRepository.deleteById(idNovedad);
	}

	@Override
	public Novedad buscar(Integer idNovedad) {
		return novedadRepository.findById(idNovedad).orElse(null);
	}

	@Override
	public void actualizar(Novedad novedad) {
		novedadRepository.save(novedad);
		
	}
	
	 public List<Novedad> listarPorPeriodo(LocalDate periodo) {
	        return novedadRepository.findByPeriodo(periodo);
	    }

}
