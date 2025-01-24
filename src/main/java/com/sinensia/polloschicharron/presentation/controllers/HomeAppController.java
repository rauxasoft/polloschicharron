package com.sinensia.polloschicharron.presentation.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class HomeAppController {

	@GetMapping({"/home", "/"})
	public String getHome() {		
		return "index";       //     /WEB-INF/vistas/index.jsp   
	}
}
