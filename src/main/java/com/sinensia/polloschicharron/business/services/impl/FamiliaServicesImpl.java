package com.sinensia.polloschicharron.business.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.sinensia.polloschicharron.business.model.Familia;
import com.sinensia.polloschicharron.business.services.FamiliaServices;

public class FamiliaServicesImpl implements FamiliaServices {

	private final Map<Long, Familia> FAMILIAS_DB = new HashMap<>();
	
	public FamiliaServicesImpl() {
		init();
	}
	
	@Override
	public Long create(Familia familia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Familia> read(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void update(Familia familia) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Familia> getAll() {
		// TODO Auto-generated method stub
		return null;
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
		
		familia1.setId(100L);
		familia2.setId(101L);
		familia3.setId(102L);
		familia4.setId(103L);
		
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
