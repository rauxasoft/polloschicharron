package com.sinensia.polloschicharron.business.services.impl.temporal.test;

import java.util.Optional;

import com.sinensia.polloschicharron.business.model.Establecimiento;
import com.sinensia.polloschicharron.business.services.EstablecimientoServices;
import com.sinensia.polloschicharron.business.services.impl.EstablecimientoServicesImpl;

public class EstablecimientoServicesImplTest {

	public static void main(String[] args) {
		
		EstablecimientoServices establecimientoServices = new EstablecimientoServicesImpl();
		
		Establecimiento establecimiento1 = new Establecimiento();
		establecimiento1.setNIF("B11111111");
		establecimiento1.setNombre("Establecimeinto Puebas");
		
		establecimientoServices.create(establecimiento1);
		
		establecimiento1 = null;
		
		Optional<Establecimiento> optional = establecimientoServices.read("B11111111");
		
		System.out.println(optional.get()); // Comprobamos por consola de forma manual
		
		System.out.println("\n***************************************");
		
		for(Establecimiento establecimiento: establecimientoServices.getAll()) {
			System.out.println(establecimiento);
		}
		
		System.out.println("\n***************************************");
		
		for(Establecimiento establecimiento: establecimientoServices.getByProvincia("Madrid")) {
			System.out.println(establecimiento);
		}
		

	}

}
