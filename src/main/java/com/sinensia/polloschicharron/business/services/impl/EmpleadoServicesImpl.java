package com.sinensia.polloschicharron.business.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sinensia.polloschicharron.business.model.Empleado;
import com.sinensia.polloschicharron.business.services.EmpleadoServices;
import com.sinensia.polloschicharron.integration.repositories.EmpleadoRepository;

@Service
public class EmpleadoServicesImpl implements EmpleadoServices {

	private EmpleadoRepository empleadoRepository;
	
	public EmpleadoServicesImpl(EmpleadoRepository empleadoRepository) {
		this.empleadoRepository = empleadoRepository;
	}
	
	@Override
	public Optional<Empleado> read(String DNI) {
		return empleadoRepository.findById(DNI);
	}

	@Override
	public List<Empleado> getAll() {
		return empleadoRepository.findAll();
	}
	
}
