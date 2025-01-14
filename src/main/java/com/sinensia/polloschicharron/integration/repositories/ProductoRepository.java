package com.sinensia.polloschicharron.integration.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sinensia.polloschicharron.business.model.Familia;
import com.sinensia.polloschicharron.business.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

	List<Producto> findByPrecioBetweenOrderByPrecioDesc(double min, double max);
	
	List<Producto> findByFechaAltaBetweenOrderByFechaAltaDesc(Date desde, Date hasta);
	
	List<Producto> findByFamilia(Familia familia);
		
}
