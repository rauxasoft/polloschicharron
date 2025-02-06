package com.sinensia.polloschicharron.auditoria.presentation.controllers;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinensia.polloschicharron.auditoria.integration.repositories.RequestLogPLRepository;

@Controller
@RequestMapping("/admin/auditoria")
public class RequestLogPLController {

	private RequestLogPLRepository requestLogPLRepository;

	public RequestLogPLController(RequestLogPLRepository requestLogPLRepository) {
		this.requestLogPLRepository = requestLogPLRepository;
	}
	
	// http://localhost:8080/admin/auditoria/lista-logs
	
	@GetMapping("/lista-logs")
	public ModelAndView getListaEmpleados(ModelAndView mav) {
		mav.addObject("logs", requestLogPLRepository.findAll(Sort.by("id").descending()));
		mav.setViewName("listado-logs");
		return mav;
	}
	
}
