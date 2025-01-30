package com.sinensia.polloschicharron.business.services.impl;

import java.util.List;
import java.util.Optional;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import com.sinensia.polloschicharron.business.model.Establecimiento;
import com.sinensia.polloschicharron.business.model.dtos.EstablecimientoDTO1;
import com.sinensia.polloschicharron.business.services.EstablecimientoServices;
import com.sinensia.polloschicharron.integration.model.EstablecimientoPL;
import com.sinensia.polloschicharron.integration.repositories.EstablecimientoPLRepository;

import jakarta.transaction.Transactional;

@Service
public class EstablecimientoServicesImpl implements EstablecimientoServices {

	private EstablecimientoPLRepository establecimientoPLRepository;
	private DozerBeanMapper mapper;
	
	public EstablecimientoServicesImpl(EstablecimientoPLRepository establecimientoRepository, DozerBeanMapper mapper) {
		this.establecimientoPLRepository = establecimientoRepository;
		this.mapper = mapper;
	}
	
	@Override
	@Transactional
	public void create(Establecimiento establecimiento) {

		String NIF = establecimiento.getNIF();
		
		boolean existe = establecimientoPLRepository.existsById(NIF);
		
		if(NIF == null || existe) {
			throw new IllegalStateException("El NIF [" + NIF + "] no es válido o ya existe.");
		}
		
		EstablecimientoPL establecimientoPL = mapper.map(establecimiento, EstablecimientoPL.class);
		
		establecimientoPLRepository.save(establecimientoPL);
		
	}

	@Override
	public Optional<Establecimiento> read(String NIF) {
		
		Optional<EstablecimientoPL> optionalPL = establecimientoPLRepository.findById(NIF);
		
		return optionalPL.isEmpty() ? Optional.empty() : Optional.of(mapper.map(optionalPL.get(), Establecimiento.class));
	}

	@Override
	@Transactional
	public void update(Establecimiento establecimiento) {

		String NIF = establecimiento.getNIF();
		
		boolean existe = establecimientoPLRepository.existsById(NIF);
		
		if(NIF == null || !existe) {
			throw new IllegalStateException("El establecimiento con NIF [" + NIF + "] no existe.");
		}
		
		establecimientoPLRepository.save(mapper.map(establecimiento, EstablecimientoPL.class));
		
	}

	@Override
	public List<Establecimiento> getAll() {
		return establecimientoPLRepository.findAll().stream()
				.map(x -> mapper.map(x, Establecimiento.class))
				.toList();
	}

	@Override
	public List<Establecimiento> getByProvincia(String provincia) {
		return establecimientoPLRepository.findByDireccionProvinciaIgnoreCase(provincia).stream()
				.map(x -> mapper.map(x, Establecimiento.class))
				.toList();
	}
	
	// ***********************************
	//
	// DTOs
	//
	// ***********************************	

	@Override
	public List<EstablecimientoDTO1> getEstablecimientosDTO1() {
		return establecimientoPLRepository.findDTO1();
	}
	
}
