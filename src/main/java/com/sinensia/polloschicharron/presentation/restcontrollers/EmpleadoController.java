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
	
	@GetMapping("/{dni}")
	public Empleado getEmpleado(@PathVariable String dni) {
		
		Optional<Empleado> optional = empleadoServices.read(dni);
		
		if(optional.isEmpty()) {
			throw new PresentationException("No existe el empleado con DNI " + dni, HttpStatus.NOT_FOUND);
		}
		
		return optional.get();
	}

}
