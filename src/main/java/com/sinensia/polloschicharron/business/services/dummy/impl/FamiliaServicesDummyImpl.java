package com.sinensia.polloschicharron.business.services.dummy.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.sinensia.polloschicharron.business.model.Familia;
import com.sinensia.polloschicharron.business.services.FamiliaServices;

public class FamiliaServicesDummyImpl implements FamiliaServices {

	private final Map<Long, Familia> FAMILIAS_DB = new HashMap<>();
	
	public FamiliaServicesDummyImpl() {
		init();
	}
		
	@Override
	public Long create(Familia familia) {
		
		if(familia.getId() != null) {
			throw new IllegalStateException("Para crear una familia el id ha de ser null.");
		}
		
		boolean existe = true;
		Long idRandom = null;
		
		while(existe) {
			idRandom = (long) (Math.random() * 1000000000000L);
			existe = FAMILIAS_DB.containsKey(idRandom);
		}
		
		familia.setId(idRandom);
		
		FAMILIAS_DB.put(idRandom, familia);
	
		return idRandom;
	}

	@Override
	public Optional<Familia> read(Long id) {
		return Optional.ofNullable(FAMILIAS_DB.get(id));
	}

	@Override
	public void update(Familia familia) {
		
		Long id = familia.getId(); 
		
		boolean existe = FAMILIAS_DB.containsKey(id);
		
		if(!existe) {
			throw new IllegalStateException("La familia con ID [" + id + "] no existe.");
		}
		
		FAMILIAS_DB.replace(id, familia);
		
	}

	@Override
	public List<Familia> getAll() {
		return new ArrayList<>(FAMILIAS_DB.values());
	}
	
	// ********************************************
	//
	// Private Methods
	//
	// ********************************************
		
	private void init() {
		
		Familia familia1 = new Familia();
		Familia familia2 = new Familia();
		Familia familia3 = new Familia();
		Familia familia4 = new Familia();
		
		familia1.setId(2L);
		familia2.setId(3L);
		familia3.setId(4L);
		familia4.setId(5L);
		
		familia1.setNombre("CERVEZAS");
		familia2.setNombre("TAPAS");
		familia3.setNombre("POSTRES");
		familia4.setNombre("CAFES");
		
		FAMILIAS_DB.put(familia1.getId(), familia1);
		FAMILIAS_DB.put(familia2.getId(), familia2);
		FAMILIAS_DB.put(familia3.getId(), familia3);
		FAMILIAS_DB.put(familia4.getId(), familia4);
		
	}

}
