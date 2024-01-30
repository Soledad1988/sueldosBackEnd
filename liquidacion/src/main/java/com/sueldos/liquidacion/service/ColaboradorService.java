package com.sueldos.liquidacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sueldos.liquidacion.model.Colaborador;
import com.sueldos.liquidacion.model.Liquidacion;
import com.sueldos.liquidacion.model.LiquidacionComercio;
import com.sueldos.liquidacion.repository.ColaboradorRepository;
import com.sueldos.liquidacion.repository.LiquidacionRepository;

@Service
public class ColaboradorService implements IColaboradorService{

	@Autowired
	private ColaboradorRepository colaboradorRepository;
	
	@Override
	public void crear(Colaborador colaborador) {
		colaboradorRepository.save(colaborador);
	}

	@Override
	public List<Colaborador> listar() {
		return colaboradorRepository.findAll();
	}

	@Override
	public void borrar(Integer id) {
		colaboradorRepository.deleteById(id);		
	}

	@Override
	public Colaborador buscar(Integer id) {
		return colaboradorRepository.findById(id).orElse(null);
	}

	@Override
	public void actualizar(Colaborador colaborador) {
		colaboradorRepository.save(colaborador);
	}
	

}
