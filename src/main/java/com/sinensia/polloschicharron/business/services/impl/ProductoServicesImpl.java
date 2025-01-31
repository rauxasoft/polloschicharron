package com.sinensia.polloschicharron.business.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import com.sinensia.polloschicharron.business.model.Familia;
import com.sinensia.polloschicharron.business.model.Producto;
import com.sinensia.polloschicharron.business.model.dtos.ProductoDTO1;
import com.sinensia.polloschicharron.business.model.dtos.ProductoDTO2;
import com.sinensia.polloschicharron.business.model.dtos.ProductoDTO3;
import com.sinensia.polloschicharron.business.services.ProductoServices;
import com.sinensia.polloschicharron.integration.model.FamiliaPL;
import com.sinensia.polloschicharron.integration.model.ProductoPL;
import com.sinensia.polloschicharron.integration.repositories.ProductoPLRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductoServicesImpl implements ProductoServices{

	private final ProductoPLRepository productoPLRepository;
	private DozerBeanMapper mapper;
  
	public ProductoServicesImpl(ProductoPLRepository productoRepository, DozerBeanMapper mapper) {
		this.productoPLRepository = productoRepository;
		this.mapper = mapper;
	}

	@Override
	@Transactional
	public Long create(Producto producto) {
		
		if(producto.getId() != null) {
			throw new IllegalStateException("Para crear un producto el id ha de ser null.");
		}
			
		ProductoPL productoPL = mapper.map(producto, ProductoPL.class);
		ProductoPL createdProductoPL = productoPLRepository.save(productoPL);
    
		return createdProductoPL.getId();
	}

	@Override
	public Optional<Producto> read(Long id) {

		Optional<ProductoPL> optionalPL = productoPLRepository.findById(id);
	
		return optionalPL.isEmpty() ? Optional.empty() : Optional.of(mapper.map(optionalPL.get(), Producto.class));
	}

	@Override
	@Transactional
	public void update(Producto producto) {

		Long id = producto.getId(); 
		
		boolean existe = productoPLRepository.existsById(id);
		
		if(!existe) {
			throw new IllegalStateException("El producto con ID [" + id + "] no existe.");
		}
		
		productoPLRepository.save(mapper.map(producto, ProductoPL.class));
		
	}

	@Override
	@Transactional
	public void delete(Long id) {
		
		boolean existe = productoPLRepository.existsById(id);
		
		if(!existe) {
			throw new IllegalStateException("El producto con ID [" + id + "] no existe.");	
		}
    
		Optional<ProductoPL> optionalPL = productoPLRepository.findById(id);
		optionalPL.get().setDescatalogado(true);

	}

	@Override
	public List<Producto> getAll() {
	  return convertProductosPLToProductos(productoPLRepository.findAll());
	}

	@Override
	public List<Producto> getBetweenPriceRange(double min, double max) {
		return convertProductosPLToProductos(productoPLRepository.findByPrecioBetweenOrderByPrecioDesc(min, max));
	}

	@Override
	public List<Producto> getBetweenFechaAlta(Date desde, Date hasta) {
		return convertProductosPLToProductos(productoPLRepository.findByFechaAltaBetweenOrderByFechaAltaDesc(desde, hasta));
	}

	@Override
	public List<Producto> getByFamilia(Familia familia) {
		FamiliaPL familiaPL = mapper.map(familia, FamiliaPL.class);
		return convertProductosPLToProductos(productoPLRepository.findByFamilia(familiaPL));
	}

	@Override
	public int getNumeroTotalProductos() {
		return (int) productoPLRepository.count();
	}

	@Override
	public int getNumeroTotalProductosByFamilia(Familia familia) {
		FamiliaPL familiaPL = mapper.map(familia, FamiliaPL.class);
		return (int) productoPLRepository.getNumeroTotalProductosByFamilia(familiaPL);
	}

	@Override
	@Transactional
	public void incrementarPrecio(Familia familia, double porcentaje) {
		FamiliaPL familiaPL = mapper.map(familia, FamiliaPL.class);
		productoPLRepository.incrementarPrecio(familiaPL, porcentaje);	
	}

	@Override
	@Transactional
	public void incrementarPrecio(List<Producto> productos, double porcentaje) {
		productoPLRepository.incrementarPrecio(mapper.map(productos, FamiliaPL.class), porcentaje);
	}

	@Override
	public void incrementarPrecio(double porcentaje, Long... ids) {
		productoPLRepository.incrementarPrecio(porcentaje, ids);
	}

	@Override
	public Map<Familia, Integer> getEstadisticaNumeroProductosPorFamilia() {
	
		return productoPLRepository.getEstadisticaNumeroProductosPorFamilia()
				.stream()
				.collect(Collectors.toMap(x -> mapper.map((FamiliaPL) x[0], Familia.class), 
										  x -> ((Long) x[1]).intValue()));
		
	}

	@Override
	public Map<Familia, Double> getEstadisticaPrecioMedioProductosPorFamilia() {
		
		Map<Familia, Double> estadistica = new HashMap<>();
		
		productoPLRepository.getEstadisticaPrecioMedioProductosPorFamilia()
			.forEach(x -> estadistica.put(mapper.map((FamiliaPL) x[0], Familia.class), (Double) x[1]));
		
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
	

	// ********************************************
	//
	// Private Methods
	//
	// ********************************************
	
	private List<Producto> convertProductosPLToProductos(List<ProductoPL> productosPL){
		
		return productosPL.stream()
				.map(x -> mapper.map(x, Producto.class))
				.toList();
	}

}
