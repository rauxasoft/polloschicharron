package com.sinensia.polloschicharron.business.services;

import java.util.List;
import java.util.Optional;

import com.sinensia.polloschicharron.business.model.Establecimiento;

public interface EstablecimientoServices {

	/**
	 * Si el NIF es null o ya existe lanza IllegalStateException
	 * 
	 * 
	 */
	void create(Establecimiento establecimiento);
	
	Optional<Establecimiento> read(String NIF);
	
	/**
	 * Si el NIF es null o no existe lanza IllegalStateException
	 * 
	 */
	void update(Establecimiento establecimiento);
	
	List<Establecimiento> getAll();
	
	List<Establecimiento> getByProvincia(String provincia);
	
}
