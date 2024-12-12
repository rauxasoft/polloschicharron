package com.sinensia.polloschicharron.business.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.sinensia.polloschicharron.business.model.DatosContacto;
import com.sinensia.polloschicharron.business.model.Direccion;
import com.sinensia.polloschicharron.business.model.Establecimiento;
import com.sinensia.polloschicharron.business.services.EstablecimientoServices;

public class EstablecimientoServicesImpl implements EstablecimientoServices {

	private final Map<String, Establecimiento> ESTABLECIMIENTOS_DB = new HashMap<>();
	
	public EstablecimientoServicesImpl() {
		init();
	}
	
	@Override
	public void create(Establecimiento establecimiento) {
		
		String NIF = establecimiento.getNIF();
		
		boolean existe = ESTABLECIMIENTOS_DB.containsKey(NIF);
		
		if(NIF == null || existe) {
			throw new IllegalStateException("El NIF [" + NIF + "] no es válido.");
		}
		
		ESTABLECIMIENTOS_DB.put(NIF, establecimiento);
		
	}

	@Override
	public Optional<Establecimiento> read(String NIF) {
		return Optional.ofNullable(ESTABLECIMIENTOS_DB.get(NIF));
	}

	@Override
	public void update(Establecimiento establecimiento) {
		
		String NIF = establecimiento.getNIF();
		
		boolean existe = ESTABLECIMIENTOS_DB.containsKey(NIF);
		
		if(NIF == null || !existe) {
			throw new IllegalStateException("El establecimiento con NIF [" + NIF + "] no existe.");
		}
		
		ESTABLECIMIENTOS_DB.replace(NIF, establecimiento);
		
	}

	@Override
	public List<Establecimiento> getAll() {
		return new ArrayList<>(ESTABLECIMIENTOS_DB.values());	
	}

	@Override
	public List<Establecimiento> getByProvincia(String provincia) {

		List<Establecimiento> establecimientos = new ArrayList<>();
		
		for(Establecimiento establecimiento: ESTABLECIMIENTOS_DB.values()) {
			
			boolean contieneDireccion = establecimiento.getDireccion() != null;
			
			if(contieneDireccion && establecimiento.getDireccion().getProvincia().equals(provincia)) {
				establecimientos.add(establecimiento);
			}
		}
		
		return establecimientos;
	}
	
	// ********************************************
	//
	// Private Methods
	//
	// ********************************************
	
	private void init() {
		
		Establecimiento establecimiento1 = new Establecimiento();
		Establecimiento establecimiento2 = new Establecimiento();
		Establecimiento establecimiento3 = new Establecimiento();
		Establecimiento establecimiento4 = new Establecimiento();
		
		establecimiento1.setNIF("B20990231");
		establecimiento2.setNIF("B20090188");
		establecimiento3.setNIF("B27855671");
		establecimiento4.setNIF("B22409011");
		
		establecimiento1.setNombre("Pollos Chicharrón - Gran Vía II");
		establecimiento2.setNombre("Pollos Chicharrón - La Vaguada");
		establecimiento3.setNombre("Pollos Chicharrón - Vallés Nord");
		establecimiento4.setNombre("Pollos Chicharrón - Sant Celoni");
		
		Direccion direccion1 = new Direccion();
		Direccion direccion2 = new Direccion();
		Direccion direccion3 = new Direccion();
		Direccion direccion4 = new Direccion();
		
		direccion1.setDireccion("Gran Via de les Corts Catalanes, 234");
		direccion1.setPoblacion("Barcelona");
		direccion1.setCodigoPostal("08020");
		direccion1.setProvincia("Barcelona");
		direccion1.setPais("España");
		
		direccion2.setDireccion("Avda del Pino, 34");
		direccion2.setPoblacion("Madrid");
		direccion2.setCodigoPostal("89032");
		direccion2.setProvincia("Madrid");
		direccion2.setPais("España");
		
		direccion3.setDireccion("c/ Industria, 2");
		direccion3.setPoblacion("Sabt Cugat");
		direccion3.setCodigoPostal("08112");
		direccion3.setProvincia("Barcelona");
		direccion3.setPais("España");
		
		direccion4.setDireccion("c/ Montseny, 12");
		direccion4.setPoblacion("Sant Celoni");
		direccion4.setCodigoPostal("08923");
		direccion4.setProvincia("Barcelona");
		direccion4.setPais("España");
		
		DatosContacto datosContacto1 = new DatosContacto();
		DatosContacto datosContacto2 = new DatosContacto();
		DatosContacto datosContacto3 = new DatosContacto();
		DatosContacto datosContacto4 = new DatosContacto();
		
		datosContacto1.setEmail("granvia@polloschicharrones.com");
		datosContacto1.setTelefono("+34 932209082");
		datosContacto1.setMovil("+34 620908423");
		
		datosContacto2.setEmail("vaguada@polloschicharrones.com");
		datosContacto2.setTelefono("+34 912314454");
		datosContacto2.setMovil("+34 6209084234");
				
		datosContacto3.setEmail("vallesnord@polloschicharrones.com");
		datosContacto3.setTelefono("+34 934209082");
		datosContacto3.setMovil("+34 620908425");
		
		datosContacto4.setEmail("santceloni@polloschicharrones.com");
		datosContacto4.setTelefono("+34 932409090");
		datosContacto4.setMovil("+34 620908426");
		
		establecimiento1.setDireccion(direccion1);
		establecimiento1.setDatosContacto(datosContacto1);
		
		establecimiento2.setDireccion(direccion2);
		establecimiento2.setDatosContacto(datosContacto2);
		
		establecimiento3.setDireccion(direccion3);
		establecimiento3.setDatosContacto(datosContacto3);
		
		establecimiento4.setDireccion(direccion4);
		establecimiento4.setDatosContacto(datosContacto4);
		
		ESTABLECIMIENTOS_DB.put(establecimiento1.getNIF(), establecimiento1);
		ESTABLECIMIENTOS_DB.put(establecimiento2.getNIF(), establecimiento2);
		ESTABLECIMIENTOS_DB.put(establecimiento3.getNIF(), establecimiento3);
		ESTABLECIMIENTOS_DB.put(establecimiento4.getNIF(), establecimiento4);
		
	}

}
