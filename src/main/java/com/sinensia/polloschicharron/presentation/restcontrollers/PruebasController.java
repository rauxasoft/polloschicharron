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

	// SHOW CASE
	// DEMO PROVISIONAL
	// TODO BORRAR ESTA CLASE!!!!
	
	@Autowired
	private ProductoRepository productoRepository;
	
	@GetMapping("/2")
	public List<Object[]> prueba2(){
		
		List<Object[]> resultados = productoRepository.findDTO1();
		
		resultados.stream().forEach(x -> {
			System.out.println(x[0] + " ---> " + x[1] + " " + x[2]);
		});
		
		
		return productoRepository.findDTO1();
	}
	
	@GetMapping("/1")
	public List<Producto> prueba1(){
		return productoRepository.dameBebidasCaraas(5.0);
	}
}
 