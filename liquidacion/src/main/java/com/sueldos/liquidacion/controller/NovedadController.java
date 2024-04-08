package com.sueldos.liquidacion.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sueldos.liquidacion.model.Colaborador;
import com.sueldos.liquidacion.model.Novedad;
import com.sueldos.liquidacion.service.ColaboradorService;
import com.sueldos.liquidacion.service.NovedadService;

@CrossOrigin
@RestController
@RequestMapping("/novedad")
public class NovedadController {
	
	@Autowired
	private NovedadService novedadService;
	
	@Autowired
    private ColaboradorService colaboradorService; 
	
	@PostMapping
	public void crear(@RequestBody Novedad novedad) {
		novedadService.crear(novedad);;
	}
	
	@GetMapping
	public List<Novedad>listar(){
		return novedadService.listar();
	}
	
	@GetMapping("/{idNovedad}")
    public Novedad get(@PathVariable("idNovedad") Integer idNovedad){
       return novedadService.buscar(idNovedad);
    }
   
	@DeleteMapping("/{idNovedad}")
	void borrar(@PathVariable Integer idNovedad){
		novedadService.borrar(idNovedad);
	}
  
	@PutMapping
	public void actualizar(@RequestBody Novedad novedad){
		novedadService.actualizar(novedad);
	 }
	
	 @PostMapping("/{idColaborador}") // Modificamos para que acepte el ID del colaborador
	    public void crear(@PathVariable("idColaborador") Integer idColaborador, @RequestBody Novedad novedad) {
	        // Buscamos el colaborador por su ID
	        Colaborador colaborador = colaboradorService.buscar(idColaborador);
	        if (colaborador != null) {
	            // Asignamos el colaborador a la novedad
	            novedad.setColaborador(colaborador);
	            // Guardamos la novedad
	            novedadService.crear(novedad);
	        } else {
	            // Manejo si el colaborador no existe
	            // Puedes lanzar una excepción, devolver un ResponseEntity con un mensaje de error, etc.
	        }
	    }
	 
	 
	 @GetMapping("/month/{month}/year/{year}")
	 public List<Novedad> listarPorMesYAnio(@PathVariable("month") Integer month, @PathVariable("year") Integer year) {
	     // Crear las fechas de inicio y fin del mes y año proporcionados
	     LocalDate startDate = LocalDate.of(year, month, 1);
	     LocalDate endDate = startDate.withDayOfMonth(startDate.lengthOfMonth());
	     
	     // Llamar al servicio para obtener las novedades filtradas por el rango de fechas
	     return novedadService.listarPorPeriodo(startDate, endDate);
	 }
}
