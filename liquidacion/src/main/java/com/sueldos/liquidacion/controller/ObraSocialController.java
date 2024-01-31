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

import com.sueldos.liquidacion.model.ObraSocial;
import com.sueldos.liquidacion.service.ObraSocialService;

@CrossOrigin
@RestController
@RequestMapping("/obraSocial")
public class ObraSocialController {
	
	@Autowired
	private ObraSocialService obraSocialService;
	
	@PostMapping
	public void crear(@RequestBody ObraSocial obraSocial) {
		obraSocialService.crear(obraSocial);;
	}
	
	@GetMapping
	public List<ObraSocial>listar(){
		return obraSocialService.listar();
	}
	
	@GetMapping("/{idObraSocial}")
    public ObraSocial get(@PathVariable("idObraSocial") Integer idObraSocial){
       return obraSocialService.buscar(idObraSocial);
    }
   
	@DeleteMapping("/{idObraSocial}")
	void borrar(@PathVariable Integer idObraSocial){
		obraSocialService.borrar(idObraSocial);
	}
  
	@PutMapping
	public void actualizar(@RequestBody ObraSocial obraSocial){
		obraSocialService.actualizar(obraSocial);
	 }
	

}
