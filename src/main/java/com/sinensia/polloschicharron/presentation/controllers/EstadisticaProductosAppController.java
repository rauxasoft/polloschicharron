package com.sinensia.polloschicharron.presentation.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinensia.polloschicharron.business.model.Familia;
import com.sinensia.polloschicharron.business.services.ProductoServices;

@Controller
@RequestMapping("/app")
public class EstadisticaProductosAppController {

	private ProductoServices productoServices;
	
	public EstadisticaProductosAppController(ProductoServices productoServices) {
		this.productoServices = productoServices;
	}
	
	@GetMapping("/estadisticas-producto")
	public ModelAndView getEstadisticasProducto(ModelAndView mav) {
	
		Integer numeroProductos = productoServices.getNumeroTotalProductos();
		Map<Familia, Integer> estadisticaNumeroProductos = productoServices.getEstadisticaNumeroProductosPorFamilia();
		Map<Familia, Double> estadisticaPrecioMedio = productoServices.getEstadisticaPrecioMedioProductosPorFamilia();
		
		mav.addObject("numeroProductos", numeroProductos);  
		mav.addObject("mapa1", estadisticaNumeroProductos);
		mav.addObject("mapa2", estadisticaPrecioMedio);
		
		mav.setViewName("estadisticas-producto"); 			
		
		return mav;
	}
	
}
