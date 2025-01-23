package com.sinensia.polloschicharron.presentation.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinensia.polloschicharron.business.services.ProductoServices;

@Controller
@RequestMapping("/app")
public class ProductoAppController {

	private ProductoServices productoServices;

	public ProductoAppController(ProductoServices productoServices) {
		this.productoServices = productoServices;
	}
	
	@GetMapping("/lista-productos")
	public ModelAndView getListaProductos(ModelAndView mav) {
		mav.addObject("productos",productoServices.getAll());
		mav.setViewName("listado-productos");
		return mav;
	}
	
}
