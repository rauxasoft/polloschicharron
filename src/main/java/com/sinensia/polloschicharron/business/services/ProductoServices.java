package com.sinensia.polloschicharron.business.services;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.sinensia.polloschicharron.business.model.Familia;
import com.sinensia.polloschicharron.business.model.Producto;

public interface ProductoServices {
	
	/**
	 * Si la id no es null lanza IllegalStateException
	 * 
	 */
	Long create(Producto producto);
	
	Optional<Producto> read(Long id);
	
	/**
	 * Si la id es null o no existe lanza IllegalStateException
	 * 
	 */
	void update(Producto producto);
	
	/**
	 * Si la id es null o no existe lanza IllegalStateException
	 * 
	 */
	void delete(Long id);
	
	List<Producto> getAll();
	
	List<Producto> getBetweenPriceRange(double min, double max);
	
	List<Producto> getBetweenFechaAlta(Date desde, Date hasta);
	
	List<Producto> getByFamilia(Familia familia);
	
	int getNumeroTotalProductos();
	
	int getNumeroTotalProductosByFamilia(Familia familia);
	
	/**
	 * Incrementa el precio de todos los productos de una familia 
	 * según el porcentaje que se indica.
	 * 
	 * Ejemplo: si porcentaje = 20.0 se incrementa el precio un 20%
	 * 
	 */
	void incrementarPrecio(Familia familia, double porcentaje);

	/**
	 * Incrementa el precio de todos los productos que se aportan 
	 * según el porcentaje que se indica.
	 * 
	 * Ejemplo: si porcentaje = 20.0 se incrementa el precio un 20%
	 * 
	 */
	void incrementarPrecio(List<Producto> productos, double porcentaje);
	
	/**
	 * Incrementa el precio de todos los productos que se aportan
	 * según el porcentaje que se indica.
	 * 
	 * (el argumento Long[] indica los ids de los productos) 
	 * 
	 * Ejemplo: si porcentaje = 20.0 se incrementa el precio un 20%
	 * 
	 */
	void incrementarPrecio(Long[] ids, double porcentaje);
	
	Map<Familia, Integer> getEstadisticaNumeroProductosPorFamilia();
	
	Map<Familia, Double> getEstadisticaPrecioMedioProductosPorFamilia();
	
}
