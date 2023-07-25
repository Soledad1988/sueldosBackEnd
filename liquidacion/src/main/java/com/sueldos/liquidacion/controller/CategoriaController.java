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
		return categoriaService.listarConvenio();
	}
	
	@GetMapping("/{idCatgeoria}")
    public Categoria get(@PathVariable("idCategoria") Integer idCategoria){
       return categoriaService.buscar(idCategoria);
    }
   
	@DeleteMapping("/{idCategoria}")
	void borrar(@PathVariable Integer idCategoria){
		categoriaService.borrar(idCategoria);
	}
  
	@PutMapping
	public void actualizar(@RequestBody Categoria categoria){
		categoriaService.actualizar(categoria);
	 }


}
