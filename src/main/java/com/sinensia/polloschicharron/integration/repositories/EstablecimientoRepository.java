package com.sinensia.polloschicharron.integration.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sinensia.polloschicharron.business.model.Establecimiento;
import com.sinensia.polloschicharron.business.model.dtos.EstablecimientoDTO1;

public interface EstablecimientoRepository extends JpaRepository<Establecimiento, String>{

	List<Establecimiento> findByDireccionProvinciaIgnoreCase(String provincia);
	
	@Query("SELECT   new com.sinensia.polloschicharron.business.model.dtos.EstablecimientoDTO1( "
		 + "             e.nombre,                                                              "
		 + "             e.direccion.poblacion,                                                 "
		 + "             e.datosContacto.telefono)                                              "
		 + "FROM     Establecimiento e                                                          "
		 + "ORDER BY e.direccion.poblacion                                                      ")
	List<EstablecimientoDTO1> findDTO1();
}
