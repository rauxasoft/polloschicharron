package com.sinensia.polloschicharron.integration.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sinensia.polloschicharron.business.model.Establecimiento;

public interface EstablecimientoRepository extends JpaRepository<Establecimiento, String>{

	// TODO ESTE (buscar documentacion) Hacer que sea case-insensitive
	// https://docs.spring.io/spring-data/jpa/docs/1.10.x/reference/pdf/spring-data-jpa-reference.pdf
	List<Establecimiento> findByDireccionProvincia(String provincia);
}
