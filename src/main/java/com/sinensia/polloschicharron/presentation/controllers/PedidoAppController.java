package com.sinensia.polloschicharron.presentation.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinensia.polloschicharron.business.services.PedidoServices;

@Controller
@RequestMapping("/app")
public class PedidoAppController {

	private PedidoServices pedidoServices;

	public PedidoAppController(PedidoServices pedidoServices) {
		this.pedidoServices = pedidoServices;
	}
	
	@GetMapping("/lista-pedidos")
	public ModelAndView getListaPedidos(ModelAndView mav) {
		mav.addObject("pedidos", pedidoServices.getPedidosDTO1());
		mav.setViewName("listado-pedidos");
		return mav;
	}
	
}
