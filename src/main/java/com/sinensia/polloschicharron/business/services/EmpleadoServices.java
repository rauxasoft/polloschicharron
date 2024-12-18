package com.sinensia.polloschicharron.business.services;

import java.util.List;
import java.util.Optional;

import com.sinensia.polloschicharron.business.model.Empleado;

public interface EmpleadoServices {

	Optional<Empleado> read(String DNI);
	
	List<Empleado> getAll();
}
