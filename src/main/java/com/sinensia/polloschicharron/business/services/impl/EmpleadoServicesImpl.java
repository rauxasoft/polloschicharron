package com.sinensia.polloschicharron.business.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.sinensia.polloschicharron.business.model.DatosContacto;
import com.sinensia.polloschicharron.business.model.Direccion;
import com.sinensia.polloschicharron.business.model.Empleado;
import com.sinensia.polloschicharron.business.services.EmpleadoServices;

public class EmpleadoServicesImpl implements EmpleadoServices {

	private final Map<String, Empleado> EMPLEADOS_DB = new HashMap<>();
	
	public EmpleadoServicesImpl() {
		init();
	}
	
	@Override
	public Optional<Empleado> read(String DNI) {
		return Optional.ofNullable(EMPLEADOS_DB.get(DNI));
	}

	@Override
	public List<Empleado> getAll() {
		return new ArrayList<>(EMPLEADOS_DB.values());
	}
	
	// ********************************************
	//
	// Private Methods
	//
	// ********************************************
	
	private void init() {
		
		Empleado empleado1 = new Empleado();
		Empleado empleado2 = new Empleado();
		
		Direccion direccion1 = new Direccion();
		Direccion direccion2 = new Direccion();
		
		DatosContacto datosContacto1 = new DatosContacto();
		DatosContacto datosContacto2 = new DatosContacto();
		
		datosContacto1.setEmail("honorio.martin@polloschicharrones.com");
		datosContacto2.setEmail("carlota.cifuentes@polloschicharrones.com");
		
		direccion1.setDireccion("Avenida Messi, 232");
		direccion1.setPoblacion("Madrid");
		direccion1.setCodigoPostal("809232");
		direccion1.setProvincia("Madrid");
		direccion1.setPais("España");
		
		direccion2.setDireccion("c/ ACDC");
		direccion2.setPoblacion("Móstoles");
		direccion2.setCodigoPostal("809442");
		direccion2.setProvincia("Madrid");
		direccion2.setPais("España");
		
		empleado1.setDNI("34009015K");
		empleado1.setNombre("Honorio");
		empleado1.setApellido1("Martín");
		empleado1.setApellido2("Salvador");
		empleado1.setDireccion(direccion1);
		empleado1.setDatosContacto(datosContacto1);
		
		empleado2.setDNI("40900243R");
		empleado2.setNombre("Carlota");
		empleado2.setApellido1("Cifuentes");
		empleado2.setApellido2("Merino");
		empleado2.setDireccion(direccion2);
		empleado2.setDatosContacto(datosContacto2);
		
		EMPLEADOS_DB.put(empleado1.getDNI(), empleado1);
		EMPLEADOS_DB.put(empleado2.getDNI(), empleado2);
		
	}

}
