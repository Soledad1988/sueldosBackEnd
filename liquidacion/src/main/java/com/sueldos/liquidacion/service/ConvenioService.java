package com.sueldos.liquidacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sueldos.liquidacion.model.Convenio;
import com.sueldos.liquidacion.repository.ConvenioRepository;

@Service
public class ConvenioService implements IConvenioService{
	
	@Autowired
	private ConvenioRepository convenioRepository;

	@Override
	public void crear(Convenio convenio) {
		convenioRepository.save(convenio);
	}

	@Override
	public List<Convenio> listar() {
		return convenioRepository.findAll();
	}

	@Override
	public void borrar(Integer id) {
		convenioRepository.deleteById(id);
	}

	@Override
	public Convenio buscar(Integer id) {
		return convenioRepository.findById(id).orElse(null);
	}

	@Override
	public void actualizar(Convenio convenio) {
		convenioRepository.save(convenio);	
	}

}
