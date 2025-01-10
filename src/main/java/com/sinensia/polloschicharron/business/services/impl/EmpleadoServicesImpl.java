package com.sinensia.polloschicharron.business.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sinensia.polloschicharron.business.model.Empleado;
import com.sinensia.polloschicharron.business.services.EmpleadoServices;

@Service
public class EmpleadoServicesImpl implements EmpleadoServices {

	@Override
	public Optional<Empleado> read(String DNI) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<Empleado> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
