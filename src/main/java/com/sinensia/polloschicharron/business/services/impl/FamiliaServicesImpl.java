package com.sinensia.polloschicharron.business.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sinensia.polloschicharron.business.model.Familia;
import com.sinensia.polloschicharron.business.services.FamiliaServices;
import com.sinensia.polloschicharron.integration.repositories.FamiliaRepository;

@Service
public class FamiliaServicesImpl implements FamiliaServices {

	private FamiliaRepository familiaRepository;
	
	public FamiliaServicesImpl(FamiliaRepository familiaRepository) {
		this.familiaRepository = familiaRepository;
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
		return familiaRepository.findAll();
	}
	
}
