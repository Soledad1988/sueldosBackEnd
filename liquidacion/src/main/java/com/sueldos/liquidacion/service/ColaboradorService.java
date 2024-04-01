package com.sueldos.liquidacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sueldos.liquidacion.model.Colaborador;
import com.sueldos.liquidacion.model.Novedad;
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
	
	//desactivar colaborador 
	public Colaborador cambiarEstadoActivoColaborador(Integer id, Boolean nuevoEstado) {
	    Optional<Colaborador> colaboradorOptional = colaboradorRepository.findById(id);
	    if (colaboradorOptional.isPresent()) {
	        Colaborador colaborador = colaboradorOptional.get();
	        colaborador.setActivo(nuevoEstado);
	        return colaboradorRepository.save(colaborador); // Retorna el colaborador actualizado
	    }
	    return null; // Retorna null si el colaborador no se encuentra
	}
	
	public void asignarNovedad(Integer idColaborador, Novedad novedad) {
        Colaborador colaborador = colaboradorRepository.findById(idColaborador).orElse(null);
        if (colaborador != null) {
            novedad.setColaborador(colaborador); // Asigna el colaborador a la novedad
            colaborador.getNovedades().add(novedad); // Agrega la novedad a la lista de novedades del colaborador
            colaboradorRepository.save(colaborador); // Guarda el colaborador actualizado con la nueva novedad
        } else {
            // Manejo de caso donde no se encuentra el colaborador
            // Puedes lanzar una excepción, registrar un error, etc.
        }
    }
	

}
