package com.sinensia.polloschicharron.integration.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import com.sinensia.polloschicharron.integration.model.FamiliaPL;
import com.sinensia.polloschicharron.integration.model.ProductoPL;

@DataJpaTest
@Sql(scripts={"classpath:data/schema_test.sql","classpath:data/data_test.sql"})
public class ProductoPLRepositoryTest {

	@Autowired
	private ProductoPLRepository productoPLRepository;
	
	@Test
	void incremetarPrecioTest() {
		
		FamiliaPL familiaPL = new FamiliaPL();
		familiaPL.setId(1L);
		
		productoPLRepository.incrementarPrecio(familiaPL, 100.0);
		
		double precioDespues1 = productoPLRepository.findById(130L).get().getPrecio();		
		double precioDespues2 = productoPLRepository.findById(100L).get().getPrecio();

		assertEquals(7.6, precioDespues1);
		assertEquals(6.0, precioDespues2);
		
	}
	
	@Test
	void incremetarPrecioListaTest() {
		
		List<ProductoPL> productosPL = new ArrayList<>();
		
		ProductoPL producto1PL = new ProductoPL();
		producto1PL.setId(100L);
		
		ProductoPL producto2PL = new ProductoPL();
		producto2PL.setId(101L);
		
		productosPL.add(producto1PL);
		productosPL.add(producto2PL);
		
		productoPLRepository.incrementarPrecio(productosPL, 100.0);
		
		double precioProducto1 = productoPLRepository.findById(100L).get().getPrecio();
		double precioProducto2 = productoPLRepository.findById(101L).get().getPrecio();

		assertEquals(12.0, precioProducto1);
		assertEquals(18.0, precioProducto2); 
		
	}
	
	@Test
	void incremetarPrecioPorIdTest() {
		
		ProductoPL producto1PL = new ProductoPL();
		producto1PL.setId(100L);
		
		ProductoPL producto2PL = new ProductoPL();
		producto2PL.setId(101L);

		Long[] ArrayDeIds = {100L, 101L};
		
		productoPLRepository.incrementarPrecio(100, ArrayDeIds);
		
		double precioProducto1 = productoPLRepository.findById(100L).get().getPrecio();
		double precioProducto2 = productoPLRepository.findById(101L).get().getPrecio();

		assertEquals(12.0, precioProducto1);
		assertEquals(18.0, precioProducto2); 
		
	}
	
	@Test
	void getEstadisticaNumeroProductosPorFamiliaTest() {
		
		FamiliaPL familiaPL = new FamiliaPL();
		familiaPL.setId(1L);
		
		double numeroTotal = productoPLRepository.getNumeroTotalProductosByFamilia(familiaPL);
		
		assertEquals(6.0, numeroTotal);
		
	}
	
	@Test
	void getEstadisticaPrecioMedioProductosPorFamiliaTest() {
		
		FamiliaPL familiaPL = new FamiliaPL();
		familiaPL.setId(1L);
		
		List<ProductoPL> productos = productoPLRepository.findByFamilia(familiaPL);
		
		Double precioMedio = productos.stream()
			.mapToDouble(x -> x.getPrecio())
			.average()
			.orElse(0.0);

		assertEquals(4.43, precioMedio, 0.01);
		
	}

}
