package com.sinensia.polloschicharron.integration.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.sinensia.polloschicharron.business.model.dtos.ProductoDTO2;
import com.sinensia.polloschicharron.business.model.dtos.ProductoDTO3;
import com.sinensia.polloschicharron.integration.model.FamiliaPL;
import com.sinensia.polloschicharron.integration.model.ProductoPL;

public interface ProductoPLRepository extends JpaRepository<ProductoPL, Long> {

	List<ProductoPL> findByPrecioBetweenOrderByPrecioDesc(double min, double max);
	
	List<ProductoPL> findByFechaAltaBetweenOrderByFechaAltaDesc(Date desde, Date hasta);
	
	List<ProductoPL> findByFamilia(FamiliaPL familia);
	
	@Query("SELECT UPPER(p.nombre), p.familia.nombre, p.precio FROM ProductoPL p")
	List<Object[]> findDTO1();

	@Query("SELECT new com.sinensia.polloschicharron.business.model.dtos.ProductoDTO2(UPPER(p.nombre),YEAR(p.fechaAlta)) FROM ProductoPL p")
	List<ProductoDTO2> findDTO2();
	
	@Query("SELECT new com.sinensia.polloschicharron.business.model.dtos.ProductoDTO3( "
			+ "p.nombre, p.familia.nombre, p.precio, p.precio - (p.precio * :descuento) / 100) "
			+ "FROM ProductoPL p")
	List<ProductoDTO3> findDTO3(Double descuento);
	
	@Query("SELECT COUNT(p) FROM ProductoPL p WHERE p.familia = :familia")
	long getNumeroTotalProductosByFamilia(FamiliaPL familia);
	
	@Modifying
	@Query("UPDATE ProductoPL p SET p.precio = p.precio + (p.precio * :porcentaje) / 100 WHERE p.familia = :familia")
	void incrementarPrecio(FamiliaPL familia, double porcentaje);
	
	@Modifying
	@Query("UPDATE ProductoPL p SET p.precio = p.precio + (p.precio * :porcentaje) / 100 WHERE p IN :productos")
	void incrementarPrecio(List<ProductoPL> productos, double porcentaje);
	
	@Modifying
	@Query("UPDATE ProductoPL p SET p.precio = p.precio + (p.precio * :porcentaje) / 100 WHERE p.id IN :ids")
	void incrementarPrecio(double porcentaje, Long[] ids);
	
	@Query("SELECT f, COUNT(p) FROM FamiliaPL f LEFT JOIN ProductoPL p ON p.familia = f GROUP BY f ")
	List<Object[]> getEstadisticaNumeroProductosPorFamilia();
	
	@Query("SELECT f, ROUND(AVG(p.precio), 2) FROM FamiliaPL f LEFT JOIN ProductoPL p ON p.familia = f GROUP BY f ")
	List<Object[]> getEstadisticaPrecioMedioProductosPorFamilia();
	
}
