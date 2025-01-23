package com.sinensia.polloschicharron.presentation.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sinensia.polloschicharron.business.model.Producto;
import com.sinensia.polloschicharron.integration.repositories.ProductoRepository;

@RestController
@RequestMapping("/pruebas")
public class PruebasController {

	@Autowired
	private ProductoRepository productoRepository;
	
	// http://localhost:8080/pruebas/pagina?page_number=0&page_size=5
	
	@GetMapping("/pagina")
	Page<Producto> getPagina(@RequestParam("page_number") Integer pageNumber, 
			                 @RequestParam("page_size") Integer pagSize ){
		return productoRepository.getPage(PageRequest.of(pageNumber, pagSize));
	}
}
