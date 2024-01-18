package com.sueldos.liquidacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sueldos.liquidacion.model.Liquidacion;
import com.sueldos.liquidacion.repository.LiquidacionRepository;

@Service
public class LiquidacionService implements ILiquidacionService{
	
	@Autowired
	private LiquidacionRepository liquidacionRepository;
	
	@Override
    public void crear(Liquidacion liquidacion) {
        liquidacion.calcularValores(); // Asegúrate de llamar al método de cálculo
        liquidacionRepository.save(liquidacion);
    }

	/*@Override
	public void crear(Liquidacion liquidacion) {
		liquidacionRepository.save(liquidacion);
		
	}*/

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
	
	/* sugerencia 
	 * @Override
    public void crear(Liquidacion liquidacion) {
        validarLiquidacion(liquidacion);
        liquidacionRepository.save(liquidacion);
    }

    @Override
    public void actualizar(Liquidacion liquidacion) {
        Liquidacion existente = buscar(liquidacion.getIdLiquidacion());
        if (existente == null) {
            throw new EntityNotFoundException("Liquidacion no encontrada con ID: " + liquidacion.getIdLiquidacion());
        }
        // Aquí puedes agregar lógica para copiar propiedades de 'liquidacion' a 'existente'
        liquidacionRepository.save(existente);
    }

    private void validarLiquidacion(Liquidacion liquidacion) {
        // Lógica de validación aquí
    }*/
	 

}
