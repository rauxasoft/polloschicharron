package com.sinensia.polloschicharron.presentation.restcontrollers;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sinensia.polloschicharron.business.model.Familia;
import com.sinensia.polloschicharron.business.model.Producto;
import com.sinensia.polloschicharron.business.model.dtos.EmpleadoDTO1;
import com.sinensia.polloschicharron.business.model.dtos.EmpleadoDTO2;
import com.sinensia.polloschicharron.business.model.dtos.ProductoDTO3;
import com.sinensia.polloschicharron.business.services.ProductoServices;
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
	private ProductoServices productoServices;
	
	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	@GetMapping("/12")
	public Map<Familia, Double> prueba12(){
		return productoServices.getEstadisticaPrecioMedioProductosPorFamilia();
	}
	
	@GetMapping("/11")
	public Map<Familia, Integer> prueba11(){
		return productoServices.getEstadisticaNumeroProductosPorFamilia();
	}
	
	@GetMapping("/10")
	public String prueba10(){
		
		List<Object[]> resultados = productoRepository.getEstadisticaNumeroProductosPorFamilia();
		
		resultados.stream().forEach(fila -> {
			System.out.println(fila[0] + ": " + fila[1]);
		});
		
		return "mirar consola";
	}
	
	@GetMapping("/9")
	public String prueba9(){
		
		productoServices.incrementarPrecio(100.0, 100L, 119L, 166L);
		
		return "Comprobar resultados en h2-console";
	}
	
	@GetMapping("/8")
	public String prueba8(){
		
		Producto p1 = new Producto();
		Producto p2 = new Producto();
		Producto p3 = new Producto();
		
		p1.setId(100L);
		p2.setId(119L);
		p3.setId(166L);

		productoServices.incrementarPrecio(Arrays.asList(p1, p2, p3), 100.0);
		
		return "Comprobar resultados en h2-console";
	}
	
	@GetMapping("/7")
	public String prueba7(@RequestParam Long id, @RequestParam Double porcentaje){
		
		Familia familia = new Familia();
		familia.setId(id);
		
		productoServices.incrementarPrecio(familia, porcentaje);
		
		return "Comprobar resultados en h2-console";
	}
	
	@GetMapping("/6")
	public Integer prueba6(@RequestParam Long id){
		
		Familia familia = new Familia();
		familia.setId(id);
		
		return productoServices.getNumeroTotalProductosByFamilia(familia);
	}
	
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
 