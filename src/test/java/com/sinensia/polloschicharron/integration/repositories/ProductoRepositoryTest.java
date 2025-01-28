package com.sinensia.polloschicharron.integration.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import com.sinensia.polloschicharron.business.model.Familia;
import com.sinensia.polloschicharron.business.model.Producto;

@DataJpaTest
@Sql(scripts={"classpath:data/schema_test.sql","classpath:data/data_test.sql"})
public class ProductoRepositoryTest {

	@Autowired
	private ProductoRepository productoRepository;
	
	@Test
	void incremetarPrecioTest() {
		
		Familia familia = new Familia();
		familia.setId(1L);
		
		productoRepository.incrementarPrecio(familia, 100.0);
		
		double precioDespues1 = productoRepository.findById(130L).get().getPrecio();		
		double precioDespues2 = productoRepository.findById(100L).get().getPrecio();

		assertEquals(7.6, precioDespues1);
		assertEquals(6.0, precioDespues2);
		
	}
	
	@Test
	void incremetarPrecioListaTest() {
		
		List<Producto> productos = new ArrayList<>();
		
		Producto producto1 = new Producto();
		producto1.setId(100L);
		
		Producto producto2 = new Producto();
		producto2.setId(101L);
		
		productos.add(producto1);
		productos.add(producto2);
		
		productoRepository.incrementarPrecio(productos, 100.0);
		
		double precioProducto1 = productoRepository.findById(100L).get().getPrecio();
		double precioProducto2 = productoRepository.findById(101L).get().getPrecio();

		assertEquals(12.0, precioProducto1);
		assertEquals(18.0, precioProducto2); 
		
	}
	
	@Test
	void incremetarPrecioPorIdTest() {
		
		Producto producto1 = new Producto();
		producto1.setId(100L);
		
		Producto producto2 = new Producto();
		producto2.setId(101L);

		Long[] ArrayDeIds = {100L, 101L};
		
		productoRepository.incrementarPrecio(100, ArrayDeIds);
		
		double precioProducto1 = productoRepository.findById(100L).get().getPrecio();
		double precioProducto2 = productoRepository.findById(101L).get().getPrecio();

		assertEquals(12.0, precioProducto1);
		assertEquals(18.0, precioProducto2); 
		
	}
	
	@Test
	void getEstadisticaNumeroProductosPorFamiliaTest() {
		
		Familia familia = new Familia();
		familia.setId(1L);
		
		double numeroTotal = productoRepository.getNumeroTotalProductosByFamilia(familia);
		
		assertEquals(6.0, numeroTotal);
		
	}
	
	@Test
	void getEstadisticaPrecioMedioProductosPorFamiliaTest() {
		
		Familia familia = new Familia();
		familia.setId(1L);
		
		List<Producto> productos = productoRepository.findByFamilia(familia);
		
		Double precioMedio = productos.stream()
			.mapToDouble(x -> x.getPrecio())
			.average()
			.orElse(0.0);

		assertEquals(4.43, precioMedio, 0.01);
		
	}

}
