package com.sinensia.polloschicharron.business.services.impl;

import java.util.List;
import java.util.Optional;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import com.sinensia.polloschicharron.business.model.Familia;
import com.sinensia.polloschicharron.business.services.FamiliaServices;
import com.sinensia.polloschicharron.integration.model.FamiliaPL;
import com.sinensia.polloschicharron.integration.repositories.FamiliaPLRepository;

import jakarta.transaction.Transactional;

@Service
public class FamiliaServicesImpl implements FamiliaServices {

	private FamiliaPLRepository familiaPLRepository;
	private DozerBeanMapper mapper;
	
	public FamiliaServicesImpl(FamiliaPLRepository familiaRepository, DozerBeanMapper mapper) {
		this.familiaPLRepository = familiaRepository;
		this.mapper = mapper;
	}
	
	@Override
	@Transactional
	public Long create(Familia familia) {
		
		if(familia.getId() != null) {
			throw new IllegalStateException("Para crear una familia el id ha de ser null.");
		}
		
		FamiliaPL familiaPL = mapper.map(familia, FamiliaPL.class);
		
		FamiliaPL createdFamiliaPL = familiaPLRepository.save(familiaPL);
		
		return createdFamiliaPL.getId();
	}
	
	@Override
	public Optional<Familia> read(Long id) {
		
		Optional<FamiliaPL> optionalPL = familiaPLRepository.findById(id);
		
		return optionalPL.isEmpty() ? Optional.empty() : Optional.of(mapper.map(optionalPL.get(), Familia.class));
	}

	@Override
	@Transactional
	public void update(Familia familia) {

		Long id = familia.getId(); 
		
		boolean existe = familiaPLRepository.existsById(id);
		
		if(!existe) {
			throw new IllegalStateException("La familia con ID [" + id + "] no existe.");
		}
		
		familiaPLRepository.save(mapper.map(familia, FamiliaPL.class));
		
	}

	@Override
	public List<Familia> getAll() {
		
		return familiaPLRepository.findAll().stream()
				.map(x -> mapper.map(x, Familia.class))
				.toList();
	}
	
}
