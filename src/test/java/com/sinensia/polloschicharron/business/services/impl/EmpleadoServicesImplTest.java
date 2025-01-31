package com.sinensia.polloschicharron.business.services.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.dozer.DozerBeanMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sinensia.polloschicharron.business.model.Empleado;
import com.sinensia.polloschicharron.business.model.dtos.EmpleadoDTO1;
import com.sinensia.polloschicharron.business.model.dtos.EmpleadoDTO2;
import com.sinensia.polloschicharron.integration.model.EmpleadoPL;
import com.sinensia.polloschicharron.integration.repositories.EmpleadoPLRepository;

@ExtendWith(MockitoExtension.class)
class EmpleadoServicesImplTest {

	@Mock
	private EmpleadoPLRepository empleadoPLRepository;
	
	@Mock
	private DozerBeanMapper mapper;
	
	@InjectMocks
	private EmpleadoServicesImpl empleadoServicesImpl;
	
	@BeforeEach
	void init() {
		initObjects();
	}
	
	private Empleado empleado1;
	private Empleado empleado2;
	private EmpleadoPL empleadoPL1;
	private EmpleadoPL empleadoPL2;
	
	@Test
	void testRead() {
		

		when(empleadoPLRepository.findById(50L)).thenReturn(Optional.of(empleadoPL1));
		when(empleadoPLRepository.findById(666L)).thenReturn(Optional.empty());
		
		when(mapper.map(empleadoPL1, Empleado.class)).thenReturn(empleado1);
		
		Optional<Empleado> optional1 = empleadoServicesImpl.read(50L);
		Optional<Empleado> optional2 = empleadoServicesImpl.read(666L);
		
		assertTrue(optional1.isPresent());
		assertTrue(optional2.isEmpty());
		
		assertEquals(50L, optional1.get().getId());
		
	}

	@Test
	void testGetAll() {
	
		when(empleadoPLRepository.findAll()).thenReturn(List.of(empleadoPL1, empleadoPL2));
		when(mapper.map(empleadoPL1, Empleado.class)).thenReturn(empleado1);
		when(mapper.map(empleadoPL2, Empleado.class)).thenReturn(empleado2);
		
		List<Empleado> empleados = empleadoServicesImpl.getAll();
		
		assertEquals(2, empleados.size());
		assertTrue(empleados.containsAll(List.of(empleado1, empleado2)));
		
	}

	@Test
	void testGetEmpleadosDTO1() {
		
		
		EmpleadoDTO1 empleadoDTO11 = new EmpleadoDTO1("Ana", "Pérez López", "2234");
		EmpleadoDTO1 empleadoDTO12 = new EmpleadoDTO1("Honorio", "Martín Salvador", "1111");
		
		when(empleadoPLRepository.findDTO1()).thenReturn(List.of(empleadoDTO11, empleadoDTO12));
		
		List<EmpleadoDTO1> empleadosDTO1 = empleadoServicesImpl.getEmpleadosDTO1();
		
		assertEquals(2, empleadosDTO1.size());
		
		Set<String> set = new HashSet<>();
		
		empleadosDTO1.stream().forEach(x -> set.add(x.getNombre() + x.getApellidos() + x.getLicencia()));
		
		assertTrue(set.containsAll(List.of("AnaPérez López2234","HonorioMartín Salvador1111")));
	}

	@Test
	void testGetEmpleadosDTO2() {
		
		EmpleadoDTO2 empleadoDTO11 = new EmpleadoDTO2("PEPIN GALVEZ", "1111", "email1@gmail.com");
		EmpleadoDTO2 empleadoDTO12 = new EmpleadoDTO2("ANA LOPEZ", "2222", "email2@gmail.com");
	
		when(empleadoPLRepository.findDTO2()).thenReturn(List.of(empleadoDTO11, empleadoDTO12));
		
		List<EmpleadoDTO2> empleadosDTO2 = empleadoServicesImpl.getEmpleadosDTO2();
		
		assertEquals(2, empleadosDTO2.size());
		
		Set<String> set = new HashSet<>();
		
		empleadosDTO2.stream().forEach(x -> set.add(x.getNombreCompleto() + x.getTelefono() + x.getEmail()));
		
		assertTrue(set.containsAll(List.of("PEPIN GALVEZ1111email1@gmail.com","ANA LOPEZ2222email2@gmail.com")));
	}
	
	// ********************************************
	//
	// Private Methods
	//
	// ********************************************
	
	private void initObjects() {
		
		empleadoPL1 = new EmpleadoPL();
		empleadoPL1.setId(50L);
		
		empleadoPL2 = new EmpleadoPL();
		empleadoPL2.setId(60L);
		
		empleado1 = new Empleado();
		empleado1.setId(50L);
		
		empleado2 = new Empleado();
		empleado2.setId(60L);
		
	}

}
