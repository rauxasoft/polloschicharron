package com.sinensia.polloschicharron.integration.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sinensia.polloschicharron.business.model.Establecimiento;

public interface EstablecimientoRepository extends JpaRepository<Establecimiento, String>{

	List<Establecimiento> findByDireccionProvinciaIgnoreCase(String provincia);
}
