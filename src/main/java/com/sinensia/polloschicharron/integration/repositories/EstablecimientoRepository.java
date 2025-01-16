package com.sinensia.polloschicharron.integration.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sinensia.polloschicharron.business.model.Establecimiento;

public interface EstablecimientoRepository extends JpaRepository<Establecimiento, String>{

	// TODO Hacer que sea case-insensitive
	List<Establecimiento> findByDireccionProvincia(String provincia);
}
