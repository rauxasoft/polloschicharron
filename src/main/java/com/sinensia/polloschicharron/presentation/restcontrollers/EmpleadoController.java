package com.sinensia.polloschicharron.presentation.restcontrollers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sinensia.polloschicharron.business.model.Empleado;
import com.sinensia.polloschicharron.business.services.EmpleadoServices;
import com.sinensia.polloschicharron.presentation.config.PresentationException;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

	private EmpleadoServices empleadoServices;
	
	public EmpleadoController(EmpleadoServices empleadoServices) {
		this.empleadoServices = empleadoServices;
	}
	
	@GetMapping
	public List<Empleado> getEmpleados(){
		return empleadoServices.getAll();
	}
	
	@GetMapping("/{id}")
	public Empleado getEmpleado(@PathVariable Long id) {
		
		Optional<Empleado> optional = empleadoServices.read(id);
		
		if(optional.isEmpty()) {
			throw new PresentationException("No existe el empleado con ID " + id, HttpStatus.NOT_FOUND);
		}
		
		return optional.get();
	}

}
