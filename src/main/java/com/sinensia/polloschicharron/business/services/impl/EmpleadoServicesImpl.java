package com.sinensia.polloschicharron.business.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sinensia.polloschicharron.business.model.Empleado;
import com.sinensia.polloschicharron.business.model.dtos.EmpleadoDTO1;
import com.sinensia.polloschicharron.business.model.dtos.EmpleadoDTO2;
import com.sinensia.polloschicharron.business.services.EmpleadoServices;
import com.sinensia.polloschicharron.integration.repositories.EmpleadoRepository;

@Service
public class EmpleadoServicesImpl implements EmpleadoServices {

	private EmpleadoRepository empleadoRepository;
	
	public EmpleadoServicesImpl(EmpleadoRepository empleadoRepository) {
		this.empleadoRepository = empleadoRepository;
	}
	
	@Override
	public Optional<Empleado> read(Long id) {
		return empleadoRepository.findById(id);
	}

	@Override
	public List<Empleado> getAll() {
		return empleadoRepository.findAll();
	}
	
	// ***********************************
	//
	// DTOs
	//
	// ***********************************	
	
	@Override
	public List<EmpleadoDTO1> getEmpleadosDTO1() {
		return empleadoRepository.findDTO1();
	}

	@Override
	public List<EmpleadoDTO2> getEmpleadosDTO2() {
		return empleadoRepository.findDTO2();
	}
	
}
