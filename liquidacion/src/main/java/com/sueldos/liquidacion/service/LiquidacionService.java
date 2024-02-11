package com.sueldos.liquidacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sueldos.liquidacion.model.Categoria;
import com.sueldos.liquidacion.model.Colaborador;
import com.sueldos.liquidacion.model.Liquidacion;
import com.sueldos.liquidacion.repository.ColaboradorRepository;
import com.sueldos.liquidacion.repository.LiquidacionRepository;

@Service
public class LiquidacionService implements ILiquidacionService{
	
	@Autowired
	private LiquidacionRepository liquidacionRepository;
	
	@Autowired
	private ColaboradorRepository colaboradorRepository;
	 
	@Override
    public void crear(Liquidacion liquidacion) {
        liquidacion.calcularValores(); // Asegúrate de llamar al método de cálculo
        liquidacionRepository.save(liquidacion);
    }

	@Override
	public List<Liquidacion> listar() {
		return liquidacionRepository.findAll();
	}

	@Override
	public void borrar(Liquidacion idLiquidacion) {
		liquidacionRepository.delete(idLiquidacion);
		
	}

	@Override
	public Liquidacion buscar(Integer idLiquidacion) {
		return liquidacionRepository.findById(idLiquidacion).orElse(null);
	}

	@Override
	public void actualizar(Liquidacion liquidacion) {
		liquidacionRepository.save(liquidacion);
		
	}
	
	public void calcularLiquidacion(Colaborador colaborador, Liquidacion liquidacion) {
        // Establecer colaborador en la liquidación
        liquidacion.setColaborador(colaborador);
        
        // Calcular valores de la liquidación
        liquidacion.calcularValores();
    }
	

}
