package com.sinensia.polloschicharron.presentation.controllers;

import java.util.Map;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinensia.polloschicharron.business.model.Familia;
import com.sinensia.polloschicharron.business.services.ProductoServices;
import com.sinensia.polloschicharron.presentation.controllers.dtos.Info;

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
		
		List<Info> listaResultados = estadisticaNumeroProductos.keySet()
			.stream()
			.map(x -> new Info(x, estadisticaNumeroProductos.get(x), estadisticaPrecioMedio.get(x)))
			.toList();
		
		mav.addObject("numeroProductos", numeroProductos);  // MODELO
		mav.addObject("listaResultados", listaResultados);  // MODELO
		
		mav.setViewName("estadisticas-producto"); 			// VISTA
		
		return mav;
	}
	
}
