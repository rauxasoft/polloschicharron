package com.sinensia.polloschicharron.presentation.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sinensia.polloschicharron.business.model.Producto;
import com.sinensia.polloschicharron.integration.repositories.ProductoRepository;

@RestController
@RequestMapping("/pruebas")
public class PruebasController {

	@Autowired
	private ProductoRepository productoRepository;
	
	@GetMapping("/1")
	public List<Producto> prueba1(){
		return productoRepository.dameBebidasCaraas(5.0);
	}
}
