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

import com.sueldos.liquidacion.model.Liquidacion;
import com.sueldos.liquidacion.service.LiquidacionService;


@CrossOrigin
@RestController
@RequestMapping("/liquidacion")
public class LiquidacionController {

	 @Autowired
	    private LiquidacionService liquidacionService;

	    @PostMapping
	    public ResponseEntity<Liquidacion> crear(@RequestBody Liquidacion liquidacion) {
	        liquidacionService.crear(liquidacion);
	        return new ResponseEntity<>(liquidacion, HttpStatus.CREATED);
	    }

	    @GetMapping
	    public ResponseEntity<List<Liquidacion>> listar() {
	        return new ResponseEntity<>(liquidacionService.listar(), HttpStatus.OK);
	    }

	    // Ejemplo de método para actualizar
	    @PutMapping("/{id}")
	    public ResponseEntity<Liquidacion> actualizar(@PathVariable Integer id, @RequestBody Liquidacion liquidacion) {
	        Liquidacion existente = liquidacionService.buscar(id);
	        if (existente == null) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	        // Copiar detalles de 'liquidacion' a 'existente' aquí
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
