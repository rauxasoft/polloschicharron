package com.sinensia.polloschicharron.integration.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import com.sinensia.polloschicharron.business.model.dtos.EmpleadoDTO1;
import com.sinensia.polloschicharron.business.model.dtos.EmpleadoDTO2;

@DataJpaTest
@Sql(scripts={"classpath:data/schema_test.sql","classpath:data/data_test.sql"})
public class EmpleadoRepositoryTest {
	
	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	@Test
	void findDTO1Test() {
		
		List<EmpleadoDTO1> empleados = empleadoRepository.findDTO1();
		
		assertEquals(4, empleados.size());
	
		String empleadoDTO1Str = "WalterPeraltaLMA009200S";
		
		Long numeroOcurrencias = empleados.stream()
			.map(x -> x.getNombre() + x.getApellidos() + x.getLicencia())
			.filter(x -> x.equals(empleadoDTO1Str)).count();
		
		assertEquals(1, numeroOcurrencias);
	}
	
	@Test
	void findDTO2Test() {
		
		List<EmpleadoDTO2> empleados = empleadoRepository.findDTO2();
		
		assertEquals(4, empleados.size());
	
		String empleadoDTO2Str = "PERALTA, WALTER982209090null";
		
		Long numeroOcurrencias = empleados.stream()
			.map(x -> x.getNombreCompleto() + x.getTelefono() + x.getEmail())
			.filter(x -> x.equals(empleadoDTO2Str)).count();
		
		assertEquals(1, numeroOcurrencias);	
	}
	
}
