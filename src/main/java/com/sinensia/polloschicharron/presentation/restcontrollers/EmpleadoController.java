package com.sinensia.polloschicharron.presentation.restcontrollers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sinensia.polloschicharron.business.model.Empleado;
import com.sinensia.polloschicharron.business.services.EmpleadoServices;
import com.sinensia.polloschicharron.presentation.config.HttpErrorCustomizado;

@RestController
public class EmpleadoController {

	@Autowired
	private EmpleadoServices empleadoServices;
	
	@GetMapping("/empleados")
	public List<Empleado> getEmpleados(){
		
		List<Empleado> empleados = empleadoServices.getAll();
		
		return empleados;
	}
	
	// GET http://localhost:8080/empleados
	// GET http://localhost:8080/empleados/46772312R 
	
	@GetMapping("/empleados/{dni}")
	public ResponseEntity<?> getEmpleado(@PathVariable String dni) {
		
		Optional<Empleado> optional = empleadoServices.read(dni);
		
		if(optional.isEmpty()) {
			HttpErrorCustomizado httpErrorCustomizado = new HttpErrorCustomizado("No existe el empleado con DNI " + dni);
			return new ResponseEntity<>(httpErrorCustomizado, HttpStatus.NOT_FOUND);
		}
		
		return ResponseEntity.of(optional);
	}
	
}
