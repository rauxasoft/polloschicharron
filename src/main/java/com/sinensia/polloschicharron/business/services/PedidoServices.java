package com.sinensia.polloschicharron.business.services;

import java.util.List;
import java.util.Optional;

import com.sinensia.polloschicharron.business.model.Pedido;

public interface PedidoServices {

	/**
	 * Si la id no es null lanza IllegalStateException
	 * 
	 */
	Long create(Pedido pedido);
	
	Optional<Pedido> read(Long id);
	
	/**
	 * Si la id es null o no existe lanza IllegalStateException
	 * 
	 */
	void update(Pedido producto);
	
	/**
	 * Si la id es null o no existe lanza IllegalStateException
	 * 
	 */
	void delete(Long id);
	
	List<Pedido> getAll();
	
}
