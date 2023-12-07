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

import com.sueldos.liquidacion.model.Categoria;
import com.sueldos.liquidacion.service.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@PostMapping
	public void crear(@RequestBody Categoria categoria) {
		categoriaService.crear(categoria);;
	}
	
	@GetMapping
	public List<Categoria>listar(){
		return categoriaService.listar();
	}
	
	@GetMapping("/{id}")
    public Categoria get(@PathVariable("id") Integer id){
       return categoriaService.buscar(id);
    }
   
	@DeleteMapping("/{id}")
	void borrar(@PathVariable Integer id){
		categoriaService.borrar(id);
	}
  
	@PutMapping
	public void actualizar(@RequestBody Categoria categoria){
		categoriaService.actualizar(categoria);
	 }

}
