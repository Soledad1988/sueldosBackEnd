package com.sueldos.liquidacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sueldos.liquidacion.model.ObraSocial;
import com.sueldos.liquidacion.repository.ObraSocialRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ObraSocialService implements IObraSocialService{
	
	@Autowired
	private ObraSocialRepository obraSocialRepository;

	@Override
	public void crear(ObraSocial obraSocial) {
		obraSocialRepository.save(obraSocial);
	}

	@Override
	public List<ObraSocial> listar() {
		return obraSocialRepository.findAll();
	}

	@Override
	public void borrar(Integer idObraSocial) {
		obraSocialRepository.deleteById(idObraSocial);
	}

	@Override
	public ObraSocial buscar(Integer idObraSocial) {
		return obraSocialRepository.findById(idObraSocial).orElse(null);
	}

	@Override
	public void actualizar(ObraSocial obraSocial) {
		obraSocialRepository.save(obraSocial);	
	}
	
	@Override
	public ObraSocial obtenerObraSocialPorId(Integer idObraSocial) {
	    return obraSocialRepository.findById(idObraSocial).orElse(null);
	}

}
