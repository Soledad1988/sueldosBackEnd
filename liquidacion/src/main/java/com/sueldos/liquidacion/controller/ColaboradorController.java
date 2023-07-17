package com.sueldos.liquidacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sueldos.liquidacion.model.Colaborador;
import com.sueldos.liquidacion.service.ColaboradorService;

@RestController
@RequestMapping("/colaborador")
public class ColaboradorController {
	
	@Autowired
	private ColaboradorService colaboradorService;
	
	@PostMapping
	public void crear(@RequestBody Colaborador colaborador) {
		colaboradorService.crear(colaborador);;
	}
	
	@GetMapping
	public List<Colaborador>listar(){
		return colaboradorService.listar();
	}
	
	@GetMapping("/{id}")
    public Colaborador get(@PathVariable("id") Integer id){
       return colaboradorService.buscar(id);
    }
   
	@DeleteMapping("/{id}")
	void borrar(@PathVariable Integer id){
		colaboradorService.borrar(id);
	}
  
	@PutMapping
	public void actualizar(@RequestBody Colaborador colaborador){
		colaboradorService.actualizar(colaborador);
	 }

}
