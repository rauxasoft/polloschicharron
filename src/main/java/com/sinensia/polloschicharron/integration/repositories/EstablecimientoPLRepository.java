package com.sinensia.polloschicharron.integration.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sinensia.polloschicharron.business.model.dtos.EstablecimientoDTO1;
import com.sinensia.polloschicharron.integration.model.EstablecimientoPL;

public interface EstablecimientoPLRepository extends JpaRepository<EstablecimientoPL, String>{

	List<EstablecimientoPL> findByDireccionProvinciaIgnoreCase(String provincia);
	
	@Query("SELECT   new com.sinensia.polloschicharron.business.model.dtos.EstablecimientoDTO1( "
		 + "             e.nombre,                                                              "
		 + "             e.direccion.poblacion,                                                 "
		 + "             e.datosContacto.telefono)                                              "
		 + "FROM     EstablecimientoPL e                                                          "
		 + "ORDER BY e.direccion.poblacion                                                      ")
	List<EstablecimientoDTO1> findDTO1();
}
