package com.sinensia.polloschicharron.business.services.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sinensia.polloschicharron.business.model.Familia;
import com.sinensia.polloschicharron.business.model.Producto;
import com.sinensia.polloschicharron.business.services.ProductoServices;
import com.sinensia.polloschicharron.integration.repositories.ProductoRepository;

@Service
public class ProductoServicesImpl implements ProductoServices{

	private final ProductoRepository productoRepository;
	
	public ProductoServicesImpl(ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
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
		return productoRepository.findAll();
	}

	@Override
	public List<Producto> getBetweenPriceRange(double min, double max) {
		return productoRepository.findByPrecioBetweenOrderByPrecioDesc(min, max);
	}

	@Override
	public List<Producto> getBetweenFechaAlta(Date desde, Date hasta) {
		return productoRepository.findByFechaAltaBetweenOrderByFechaAltaDesc(desde, hasta);
	}

	@Override
	public List<Producto> getByFamilia(Familia familia) {
		return productoRepository.findByFamilia(familia);
	}

	@Override
	public int getNumeroTotalProductos() {
		return (int) productoRepository.count();
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


}
