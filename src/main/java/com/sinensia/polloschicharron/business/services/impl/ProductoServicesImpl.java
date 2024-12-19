package com.sinensia.polloschicharron.business.services.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.sinensia.polloschicharron.business.model.Familia;
import com.sinensia.polloschicharron.business.model.Producto;
import com.sinensia.polloschicharron.business.services.ProductoServices;

public class ProductoServicesImpl implements ProductoServices{

	private final Map<Long, Producto> PRODUCTOS_DB = new HashMap<>();
	
	public ProductoServicesImpl() {
		init();
	}
	
	@Override
	public Long create(Producto producto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Producto> read(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void update(Producto producto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Producto> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> getBetweenPriceRange(double min, double max) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> getBetweenFechaAlta(Date desde, Date hasta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> getByFamilia(Familia familia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNumeroTotalProductos() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumeroTotalProductosByFamilia(Familia familia) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void incrementarPrecio(Familia familia, double porcentaje) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void incrementarPrecio(List<Producto> productos, double porcentaje) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void incrementarPrecio(Long[] ids, double porcentaje) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<Familia, Integer> getEstadisticaNumeroProductosPorFamilia() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Familia, Double> getEstadisticaPrecioMedioProductosPorFamilia() {
		// TODO Auto-generated method stub
		return null;
	}
	
	// ********************************************
	//
	// Private Methods
	//
	// ********************************************	
	
	private void init() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Familia familia1 = new Familia();
		Familia familia2 = new Familia();
		
		familia1.setId(100L);
		familia2.setId(200L);
		
		familia1.setNombre("TAPAS");
		familia2.setNombre("REFRESCOS");
		
		Date fecha1 = null; // "24/10/2022"
		Date fecha2 = null;
		Date fecha3 = null;
		
		try {
			fecha1 = sdf.parse("24/10/2022");
			fecha2 = sdf.parse("25/10/2022");
			fecha3 = sdf.parse("26/10/2022");
		} catch(Exception e) {
			
		}
	
		Producto producto1 = new Producto();
		Producto producto2 = new Producto();
		Producto producto3 = new Producto();
		
		producto1.setId(1L);
		producto1.setFamilia(familia1);
		producto1.setNombre("PATATAS BRAVAS");
		producto1.setPrecio(5.20);
		producto1.setDescatalogado(false);
		producto1.setFechaAlta(fecha1);
		
		producto2.setId(2L);
		producto2.setFamilia(familia2);
		producto2.setNombre("COCACOLA ZERO 33cl");
		producto2.setPrecio(2.4);
		producto2.setDescatalogado(false);
		producto2.setFechaAlta(fecha2);
		
		producto3.setId(3L);
		producto3.setFamilia(familia1);
		producto3.setNombre("TORTILLA DE PATATA");
		producto3.setPrecio(4.6);
		producto3.setDescatalogado(true);
		producto3.setFechaAlta(fecha3);
		
		PRODUCTOS_DB.put(producto1.getId(), producto1);
		PRODUCTOS_DB.put(producto2.getId(), producto2);
		PRODUCTOS_DB.put(producto3.getId(), producto3);
		
	}

}
