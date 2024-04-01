package com.sueldos.liquidacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sueldos.liquidacion.model.Novedad;
import com.sueldos.liquidacion.service.NovedadService;

@CrossOrigin
@RestController
@RequestMapping("/novedad")
public class NovedadController {
	
	@Autowired
	private NovedadService novedadService;
	
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

}
