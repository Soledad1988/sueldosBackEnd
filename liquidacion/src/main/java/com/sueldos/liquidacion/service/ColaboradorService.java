package com.sueldos.liquidacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sueldos.liquidacion.model.Colaborador;
import com.sueldos.liquidacion.repository.ColaboradorRepository;

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

}
