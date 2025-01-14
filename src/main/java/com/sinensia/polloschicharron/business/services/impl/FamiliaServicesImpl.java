package com.sinensia.polloschicharron.business.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sinensia.polloschicharron.business.model.Familia;
import com.sinensia.polloschicharron.business.services.FamiliaServices;
import com.sinensia.polloschicharron.integration.repositories.FamiliaRepository;

import jakarta.transaction.Transactional;

@Service
public class FamiliaServicesImpl implements FamiliaServices {

	private FamiliaRepository familiaRepository;
	
	public FamiliaServicesImpl(FamiliaRepository familiaRepository) {
		this.familiaRepository = familiaRepository;
	}
	
	@Override
	@Transactional
	public Long create(Familia familia) {
		
		if(familia.getId() != null) {
			throw new IllegalStateException("Para crear una familia el id ha de ser null.");
		}
		
		Familia createdFamilia = familiaRepository.save(familia);
		
		return createdFamilia.getId();
	}
	
	@Override
	public Optional<Familia> read(Long id) {
		return familiaRepository.findById(id);
	}

	@Override
	@Transactional
	public void update(Familia familia) {

		Long id = familia.getId(); 
		
		boolean existe = familiaRepository.existsById(id);
		
		if(!existe) {
			throw new IllegalStateException("La familia con ID [" + id + "] no existe.");
		}
		
		familiaRepository.save(familia);
		
	}

	@Override
	public List<Familia> getAll() {
		return familiaRepository.findAll();
	}
	
}
