package com.sinensia.polloschicharron.presentation.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinensia.polloschicharron.business.services.EmpleadoServices;

@Controller
@RequestMapping("/app")
public class EmpleadoAppController {
	
	private EmpleadoServices empleadoServices;

	public EmpleadoAppController(EmpleadoServices empleadoServices) {
		this.empleadoServices = empleadoServices;
	}
	
	@GetMapping("/lista-empleados")
	public ModelAndView getListaEmpleados(ModelAndView mav) {
		mav.addObject("empleados", empleadoServices.getEmpleadosDTO2());
		mav.setViewName("listado-empleados");
		return mav;
	}

}
