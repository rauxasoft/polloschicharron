package com.sinensia.polloschicharron.business.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sinensia.polloschicharron.business.model.Familia;
import com.sinensia.polloschicharron.business.model.Producto;
import com.sinensia.polloschicharron.business.model.dtos.ProductoDTO1;
import com.sinensia.polloschicharron.business.model.dtos.ProductoDTO2;
import com.sinensia.polloschicharron.business.model.dtos.ProductoDTO3;
import com.sinensia.polloschicharron.business.services.ProductoServices;
import com.sinensia.polloschicharron.integration.repositories.ProductoPLRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductoServicesImpl implements ProductoServices{

	private final ProductoPLRepository productoPLRepository;
	
	public ProductoServicesImpl(ProductoPLRepository productoRepository) {
		this.productoPLRepository = productoRepository;
	}

	@Override
	@Transactional
	public Long create(Producto producto) {
		
		if(producto.getId() != null) {
			throw new IllegalStateException("Para crear un producto el id ha de ser null.");
		}
		
		Producto createdProducto = productoPLRepository.save(producto);
		
		return createdProducto.getId();
	}

	@Override
	public Optional<Producto> read(Long id) {
		return productoPLRepository.findById(id);
	}

	@Override
	@Transactional
	public void update(Producto producto) {

		Long id = producto.getId(); 
		
		boolean existe = productoPLRepository.existsById(id);
		
		if(!existe) {
			throw new IllegalStateException("El producto con ID [" + id + "] no existe.");
		}
		
		productoPLRepository.save(producto);
		
	}

	@Override
	@Transactional
	public void delete(Long id) {
		
		boolean existe = productoPLRepository.existsById(id);
		
		if(!existe) {
			throw new IllegalStateException("El producto con ID [" + id + "] no existe.");	
		}
		
		Optional<Producto> optional = productoPLRepository.findById(id);
		optional.get().setDescatalogado(true);
		
	}

	@Override
	public List<Producto> getAll() {
		return productoPLRepository.findAll();
	}

	@Override
	public List<Producto> getBetweenPriceRange(double min, double max) {
		return productoPLRepository.findByPrecioBetweenOrderByPrecioDesc(min, max);
	}

	@Override
	public List<Producto> getBetweenFechaAlta(Date desde, Date hasta) {
		return productoPLRepository.findByFechaAltaBetweenOrderByFechaAltaDesc(desde, hasta);
	}

	@Override
	public List<Producto> getByFamilia(Familia familia) {
		return productoPLRepository.findByFamilia(familia);
	}

	@Override
	public int getNumeroTotalProductos() {
		return (int) productoPLRepository.count();
	}

	@Override
	public int getNumeroTotalProductosByFamilia(Familia familia) {
		return (int) productoPLRepository.getNumeroTotalProductosByFamilia(familia);
	}

	@Override
	@Transactional
	public void incrementarPrecio(Familia familia, double porcentaje) {
		productoPLRepository.incrementarPrecio(familia, porcentaje);	
	}

	@Override
	@Transactional
	public void incrementarPrecio(List<Producto> productos, double porcentaje) {
		productoPLRepository.incrementarPrecio(productos, porcentaje);
	}

	@Override
	public void incrementarPrecio(double porcentaje, Long... ids) {
		productoPLRepository.incrementarPrecio(porcentaje, ids);
	}

	@Override
	public Map<Familia, Integer> getEstadisticaNumeroProductosPorFamilia() {
	
		return productoPLRepository.getEstadisticaNumeroProductosPorFamilia()
				.stream()
				.collect(Collectors.toMap(x -> (Familia) x[0], 
						                  x -> ((Long) x[1]).intValue()));
		
	}

	@Override
	public Map<Familia, Double> getEstadisticaPrecioMedioProductosPorFamilia() {
		
		Map<Familia, Double> estadistica = new HashMap<>();
		
		productoPLRepository.getEstadisticaPrecioMedioProductosPorFamilia()
			.forEach(x -> estadistica.put((Familia) x[0], (Double) x[1]));
		
		return estadistica;
	}
	
	// ***********************************
	//
	// DTOs
	//
	// ***********************************	

	@Override
	public List<ProductoDTO1> getProductosDTO1() {

		List<Object[]> resultados = productoPLRepository.findDTO1();
		
		List<ProductoDTO1> productos = new ArrayList<>();

		resultados.stream().forEach(fila -> {
			
			String nombre = (String)  fila[0];
			String familia = (String) fila[1];
			Double precio = (Double)  fila[2];
			ProductoDTO1 productoDTO1 = new ProductoDTO1();
			
			productoDTO1.setNombre(nombre);
			productoDTO1.setFamilia(familia);
			productoDTO1.setPrecio(precio);
			
			productos.add(productoDTO1);
		});
		
		return productos;
	}

	@Override
	public List<ProductoDTO2> getProductosDTO2() {
		return productoPLRepository.findDTO2();
	}

	@Override
	public List<ProductoDTO3> getProductosDTO3(double descuento) {
		return productoPLRepository.findDTO3(descuento);
	}

}
