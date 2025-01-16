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

import jakarta.transaction.Transactional;

@Service
public class ProductoServicesImpl implements ProductoServices{

	private final ProductoRepository productoRepository;
	
	public ProductoServicesImpl(ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
	}

	@Override
	@Transactional
	public Long create(Producto producto) {
		
		if(producto.getId() != null) {
			throw new IllegalStateException("Para crear un producto el id ha de ser null.");
		}
		
		Producto createdProducto = productoRepository.save(producto);
		
		return createdProducto.getId();
	}

	@Override
	public Optional<Producto> read(Long id) {
		return productoRepository.findById(id);
	}

	@Override
	@Transactional
	public void update(Producto producto) {

		Long id = producto.getId(); 
		
		boolean existe = productoRepository.existsById(id);
		
		if(!existe) {
			throw new IllegalStateException("El producto con ID [" + id + "] no existe.");
		}
		
		productoRepository.save(producto);
		
	}

	@Override
	@Transactional
	public void delete(Long id) {
		
		boolean existe = productoRepository.existsById(id);
		
		if(!existe) {
			throw new IllegalStateException("El producto con ID [" + id + "] no existe.");	
		}
		
		Optional<Producto> optional = productoRepository.findById(id);
		optional.get().setDescatalogado(true);
		
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

	// ESTE (requiere de una consulta customizada en ProductoRepository que se puede resolver
	// mediante el sistema de nombres de Spring Data (ÚLTIMO)
	@Override
	public int getNumeroTotalProductosByFamilia(Familia familia) {
		// TODO ESTE (último) getNumeroTotalProductosByFamilia method stub
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
