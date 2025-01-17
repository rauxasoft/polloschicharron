package com.sinensia.polloschicharron.integration.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sinensia.polloschicharron.business.model.Familia;
import com.sinensia.polloschicharron.business.model.Producto;
import com.sinensia.polloschicharron.business.model.dtos.ProductoDTO2;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

	List<Producto> findByPrecioBetweenOrderByPrecioDesc(double min, double max);
	
	List<Producto> findByFechaAltaBetweenOrderByFechaAltaDesc(Date desde, Date hasta);
	
	List<Producto> findByFamilia(Familia familia);
		
	@Query("SELECT p FROM Producto p WHERE p.familia.id = 1 AND p.precio >= :precio")
	List<Producto> dameBebidasCaraas(Double precio);
	
	@Query("SELECT UPPER(p.nombre), p.familia.nombre, p.precio FROM Producto p")
	List<Object[]> findDTO1();

	@Query("SELECT new com.sinensia.polloschicharron.business.model.dtos.ProductoDTO2(UPPER(p.nombre),YEAR(p.fechaAlta)) FROM Producto p")
	List<ProductoDTO2> findDTO2();
}
