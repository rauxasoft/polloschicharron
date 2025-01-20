package com.sinensia.polloschicharron.presentation.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sinensia.polloschicharron.business.model.dtos.EmpleadoDTO1;
import com.sinensia.polloschicharron.business.model.dtos.EmpleadoDTO2;
import com.sinensia.polloschicharron.business.model.dtos.ProductoDTO3;
import com.sinensia.polloschicharron.integration.repositories.EmpleadoRepository;
import com.sinensia.polloschicharron.integration.repositories.ProductoRepository;

@RestController
@RequestMapping("/pruebas")
public class PruebasController {

	// SHOW CASE
	// DEMO PROVISIONAL
	// TODO BORRAR ESTA CLASE!!!!
	
	@Autowired
	private ProductoRepository productoRepository;
	
	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	@GetMapping("/5")
	public List<ProductoDTO3> prueba5(){
		return productoRepository.findDTO3(10.0);
	}
	
	@GetMapping("/4")
	public List<EmpleadoDTO2> prueba4(){
		return empleadoRepository.findDTO2();
	}
	
	@GetMapping("/3")
	public List<EmpleadoDTO1> prueba3(){
		return empleadoRepository.findDTO1();
	}
	
	@GetMapping("/2")
	public List<Object[]> prueba2(){
		
		List<Object[]> resultados = productoRepository.findDTO1();
		
		resultados.stream().forEach(x -> {
			System.out.println(x[0] + " ---> " + x[1] + " " + x[2]);
		});
		
		
		return productoRepository.findDTO1();
	}

}
 