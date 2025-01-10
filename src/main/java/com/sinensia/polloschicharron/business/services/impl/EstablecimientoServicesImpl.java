package com.sinensia.polloschicharron.business.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sinensia.polloschicharron.business.model.Establecimiento;
import com.sinensia.polloschicharron.business.services.EstablecimientoServices;

@Service
public class EstablecimientoServicesImpl implements EstablecimientoServices {

	@Override
	public void create(Establecimiento establecimiento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Establecimiento> read(String NIF) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void update(Establecimiento establecimiento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Establecimiento> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Establecimiento> getByProvincia(String provincia) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
