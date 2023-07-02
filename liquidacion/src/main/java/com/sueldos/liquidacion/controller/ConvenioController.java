package com.sueldos.liquidacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sueldos.liquidacion.model.Convenio;
import com.sueldos.liquidacion.service.ConvenioService;

@RestController
@RequestMapping("/convenio")
public class ConvenioController {

	@Autowired
	private ConvenioService convenioService;
	
	@PostMapping
	public void crear(@RequestBody Convenio convenio) {
		System.out.println(convenio);
		convenioService.crear(convenio);
	}
	
	@GetMapping
	public List<Convenio>listar(){
		return convenioService.listar();
	}
}
