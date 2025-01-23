package com.sinensia.polloschicharron.integration.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.sinensia.polloschicharron.business.model.Familia;
import com.sinensia.polloschicharron.business.model.Producto;
import com.sinensia.polloschicharron.business.model.dtos.ProductoDTO2;
import com.sinensia.polloschicharron.business.model.dtos.ProductoDTO3;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

	List<Producto> findByPrecioBetweenOrderByPrecioDesc(double min, double max);
	
	List<Producto> findByFechaAltaBetweenOrderByFechaAltaDesc(Date desde, Date hasta);
	
	List<Producto> findByFamilia(Familia familia);
		
	@Query("SELECT UPPER(p.nombre), p.familia.nombre, p.precio FROM Producto p")
	List<Object[]> findDTO1();

	@Query("SELECT new com.sinensia.polloschicharron.business.model.dtos.ProductoDTO2(UPPER(p.nombre),YEAR(p.fechaAlta)) FROM Producto p")
	List<ProductoDTO2> findDTO2();
	
	@Query("SELECT new com.sinensia.polloschicharron.business.model.dtos.ProductoDTO3( "
			+ "p.nombre, p.familia.nombre, p.precio, p.precio - (p.precio * :descuento) / 100) "
			+ "FROM Producto p")
	List<ProductoDTO3> findDTO3(Double descuento);
	
	@Query("SELECT COUNT(p) FROM Producto p WHERE p.familia = :familia")
	long getNumeroTotalProductosByFamilia(Familia familia);
	
	@Modifying
	@Query("UPDATE Producto p SET p.precio = p.precio + (p.precio * :porcentaje) / 100 WHERE p.familia = :familia")
	void incrementarPrecio(Familia familia, double porcentaje);
	
	@Modifying
	@Query("UPDATE Producto p SET p.precio = p.precio + (p.precio * :porcentaje) / 100 WHERE p IN :productos")
	void incrementarPrecio(List<Producto> productos, double porcentaje);
	
	@Modifying
	@Query("UPDATE Producto p SET p.precio = p.precio + (p.precio * :porcentaje) / 100 WHERE p.id IN :ids")
	void incrementarPrecio(double porcentaje, Long[] ids);
	
	@Query("SELECT f, COUNT(p) FROM Familia f LEFT JOIN Producto p ON p.familia = f GROUP BY f ")
	List<Object[]> getEstadisticaNumeroProductosPorFamilia();
	
	@Query("SELECT f, ROUND(AVG(p.precio), 2) FROM Familia f LEFT JOIN Producto p ON p.familia = f GROUP BY f ")
	List<Object[]> getEstadisticaPrecioMedioProductosPorFamilia();
	
}
