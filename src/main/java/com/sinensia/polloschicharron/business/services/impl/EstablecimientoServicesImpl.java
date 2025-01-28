package com.sinensia.polloschicharron.business.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sinensia.polloschicharron.business.model.Establecimiento;
import com.sinensia.polloschicharron.business.model.dtos.EstablecimientoDTO1;
import com.sinensia.polloschicharron.business.services.EstablecimientoServices;
import com.sinensia.polloschicharron.integration.repositories.EstablecimientoPLRepository;

import jakarta.transaction.Transactional;

@Service
public class EstablecimientoServicesImpl implements EstablecimientoServices {

	private EstablecimientoPLRepository establecimientoPLRepository;
	
	public EstablecimientoServicesImpl(EstablecimientoPLRepository establecimientoRepository) {
		this.establecimientoPLRepository = establecimientoRepository;
	}
	
	@Override
	@Transactional
	public void create(Establecimiento establecimiento) {

		String NIF = establecimiento.getNIF();
		
		boolean existe = establecimientoPLRepository.existsById(NIF);
		
		if(NIF == null || existe) {
			throw new IllegalStateException("El NIF [" + NIF + "] no es válido o ya existe.");
		}
		
		establecimientoPLRepository.save(establecimiento);
		
	}

	@Override
	public Optional<Establecimiento> read(String NIF) {
		return establecimientoPLRepository.findById(NIF);
	}

	@Override
	@Transactional
	public void update(Establecimiento establecimiento) {

		String NIF = establecimiento.getNIF();
		
		boolean existe = establecimientoPLRepository.existsById(NIF);
		
		if(NIF == null || !existe) {
			throw new IllegalStateException("El establecimiento con NIF [" + NIF + "] no existe.");
		}
		
		establecimientoPLRepository.save(establecimiento);
		
	}

	@Override
	public List<Establecimiento> getAll() {
		return establecimientoPLRepository.findAll();
	}

	@Override
	public List<Establecimiento> getByProvincia(String provincia) {
		return establecimientoPLRepository.findByDireccionProvinciaIgnoreCase(provincia);
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
