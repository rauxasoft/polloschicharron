package com.sinensia.polloschicharron.presentation.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
		
		mav.addObject("numeroProductos", numeroProductos);   // MODELO
		mav.setViewName("estadisticas-producto"); // VISTA
		
		return mav;
	}
}
