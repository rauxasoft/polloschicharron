package com.sinensia.polloschicharron.business.services.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sinensia.polloschicharron.business.model.Familia;
import com.sinensia.polloschicharron.business.model.Producto;
import com.sinensia.polloschicharron.business.services.ProductoServices;

@Service
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
		
		boolean existe = PRODUCTOS_DB.containsKey(id);
		
		if(!existe) {
			throw new IllegalStateException("No existe el producto con id " + id);
		}
		
		PRODUCTOS_DB.remove(id);
		
	}

	@Override
	public List<Producto> getAll() {
		return new ArrayList<>(PRODUCTOS_DB.values());
	}

	@Override
	public List<Producto> getBetweenPriceRange(double min, double max) {
		
		List<Producto> productos = new ArrayList<>();
		
		for(Producto producto: PRODUCTOS_DB.values()) {
			if(producto.getPrecio() >= min && producto.getPrecio() <= max) {
				productos.add(producto);
			}
		}
		
		return productos;
	}

	@Override
	public List<Producto> getBetweenFechaAlta(Date desde, Date hasta) {

		List<Producto> productos = new ArrayList<>();
		
		for(Producto producto: PRODUCTOS_DB.values()) {
			
			int comp1 = producto.getFechaAlta().compareTo(desde); // -> +, 0, -
			int comp2 = producto.getFechaAlta().compareTo(hasta); // -> +, 0, -
			
			if(comp1 >= 0 && comp2 <= 0) {
				productos.add(producto);
			}
		}
		
		return productos;
	}

	@Override
	public List<Producto> getByFamilia(Familia familia) {
		
		List<Producto> productos = new ArrayList<>();
		
		for(Producto producto: PRODUCTOS_DB.values()) {
			if(producto.getFamilia().equals(familia)) {
				productos.add(producto);
			}
		}
		
		return productos;
	}

	@Override
	public int getNumeroTotalProductos() {
		return PRODUCTOS_DB.size();
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
