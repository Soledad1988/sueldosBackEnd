package com.sueldos.liquidacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sueldos.liquidacion.model.Colaborador;
import com.sueldos.liquidacion.model.Liquidacion;
import com.sueldos.liquidacion.service.ColaboradorService;
import com.sueldos.liquidacion.service.LiquidacionService;


@CrossOrigin
@RestController
@RequestMapping("/liquidacion")
public class LiquidacionController {

	 	@Autowired
	    private LiquidacionService liquidacionService;
	 	
	 	@Autowired
	    private ColaboradorService colaboradorService;

	 	@PostMapping
	 	public ResponseEntity<Liquidacion> crear(@RequestBody Liquidacion liquidacion) {
	 	    // Obtener el colaborador asociado a la liquidación
	 	    Colaborador colaborador = colaboradorService.buscar(liquidacion.getColaborador().getId());
	 	    if (colaborador == null) {
	 	        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	 	    }

	 	    // Calcular la liquidación para el colaborador
	 	    colaborador.calcularLiquidacion(liquidacion);

	 	    // Guardar la liquidación en la base de datos
	 	    liquidacion.setColaborador(colaborador); // Asignar el colaborador a la liquidación
	 	    liquidacionService.crear(liquidacion);

	 	    return new ResponseEntity<>(liquidacion, HttpStatus.CREATED);
	 	}
	   
	    /*@GetMapping
	    public ResponseEntity<List<Liquidacion>> listar() {
	        return new ResponseEntity<>(liquidacionService.listar(), HttpStatus.OK);
	    }*/
	    
	 	@GetMapping
	 	public ResponseEntity<List<Liquidacion>> listarLiquidaciones() {
	 	    List<Liquidacion> liquidaciones = liquidacionService.listar();

	 	    // Calcular los valores de liquidación para cada liquidación
	 	    for (Liquidacion liquidacion : liquidaciones) {
	 	        liquidacion.calcularValores();
	 	    }

	 	    return new ResponseEntity<>(liquidaciones, HttpStatus.OK);
	 	}


	    // Ejemplo de método para actualizar
	    @PutMapping("/{id}")
	    public ResponseEntity<Liquidacion> actualizar(@PathVariable Integer id, @RequestBody Liquidacion liquidacion) {
	        Liquidacion existente = liquidacionService.buscar(id);
	        if (existente == null) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	        
	        // Copiar los detalles de la liquidación proporcionada a la liquidación existente
	        existente.setFecha(liquidacion.getFecha());
	        existente.setAntiguedad(liquidacion.getAntiguedad());
	        existente.setOtros(liquidacion.getOtros());
	        
	        // Recalcula el sueldo básico utilizando la categoría del colaborador asociado
	        Colaborador colaborador = existente.getColaborador();
	        if (colaborador != null && colaborador.getCategoria() != null) {
	            double sueldoBasico = colaborador.getCategoria().getSueldoBasico();
	           // existente.setSueldoBasico(sueldoBasico);
	        } else {
	            // Maneja el caso donde no se puede calcular el sueldo básico
	            // Esto puede ser lanzando una excepción, asignando un valor por defecto, etc.
	        }

	        liquidacionService.actualizar(existente);
	        return new ResponseEntity<>(existente, HttpStatus.OK);
	    }



	    // Ejemplo de método para buscar por ID
	    @GetMapping("/{id}")
	    public ResponseEntity<Liquidacion> buscar(@PathVariable Integer id) {
	        Liquidacion liquidacion = liquidacionService.buscar(id);
	        if (liquidacion == null) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<>(liquidacion, HttpStatus.OK);
	    }

	    // Ejemplo de método para eliminar
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> borrar(@PathVariable Integer id) {
	        Liquidacion liquidacion = liquidacionService.buscar(id);
	        if (liquidacion == null) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	        liquidacionService.borrar(liquidacion);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    
	    
}
