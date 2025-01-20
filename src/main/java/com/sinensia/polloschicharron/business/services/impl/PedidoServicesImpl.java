package com.sinensia.polloschicharron.business.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sinensia.polloschicharron.business.model.Pedido;
import com.sinensia.polloschicharron.business.services.PedidoServices;
import com.sinensia.polloschicharron.integration.repositories.PedidoRepository;

import jakarta.transaction.Transactional;

@Service
public class PedidoServicesImpl implements PedidoServices{

	private PedidoRepository pedidoRepository;
	
	public PedidoServicesImpl(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}
	
	@Override
	@Transactional
	public Long create(Pedido pedido) {
		
		if(pedido.getId() != null) {
			throw new IllegalStateException("Para crear un pedido el id ha de ser null.");
		}
		
		Pedido createdPedido = pedidoRepository.save(pedido);
		
		return createdPedido.getId();
	}

	@Override
	public Optional<Pedido> read(Long id) {
		return pedidoRepository.findById(id);
	}

	@Override
	@Transactional
	public void update(Pedido pedido) {

		Long id = pedido.getId(); 
		
		boolean existe = pedidoRepository.existsById(id);
		
		if(!existe) {
			throw new IllegalStateException("El pedido con ID [" + id + "] no existe.");
		}
		
		pedidoRepository.save(pedido);
		
	}
	
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Pedido> getAll() {
		return pedidoRepository.findAll();
	}

}
