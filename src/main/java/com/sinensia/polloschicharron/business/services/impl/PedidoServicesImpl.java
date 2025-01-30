package com.sinensia.polloschicharron.business.services.impl;

import java.util.List;
import java.util.Optional;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import com.sinensia.polloschicharron.business.model.Pedido;
import com.sinensia.polloschicharron.business.model.dtos.PedidoDTO1;
import com.sinensia.polloschicharron.business.services.PedidoServices;
import com.sinensia.polloschicharron.integration.model.PedidoPL;
import com.sinensia.polloschicharron.integration.repositories.PedidoPLRepository;

import jakarta.transaction.Transactional;

@Service
public class PedidoServicesImpl implements PedidoServices{

	private PedidoPLRepository pedidoPLRepository;
	private DozerBeanMapper mapper;
	
	public PedidoServicesImpl(PedidoPLRepository pedidoRepository, DozerBeanMapper mapper) {
		this.pedidoPLRepository = pedidoRepository;
		this.mapper = mapper;
	}
	
	@Override
	@Transactional
	public Long create(Pedido pedido) {
		
		if(pedido.getId() != null) {
			throw new IllegalStateException("Para crear un pedido el id ha de ser null.");
		}	
		
		PedidoPL pedidoPL = mapper.map(pedido, PedidoPL.class);
		PedidoPL createdPedidoPL = pedidoPLRepository.save(pedidoPL);
		
		return createdPedidoPL.getId();
	}

	@Override
	public Optional<Pedido> read(Long id) {
		
		Optional<PedidoPL> optionalPL = pedidoPLRepository.findById(id);
		
		return optionalPL.isEmpty() ? Optional.empty() : Optional.of(mapper.map(optionalPL.get(), Pedido.class));
	}

	@Override
	@Transactional
	public void update(Pedido pedido) {

		Long id = pedido.getId(); 
		
		boolean existe = pedidoPLRepository.existsById(id);
		
		if(!existe) {
			throw new IllegalStateException("El pedido con ID [" + id + "] no existe.");
		}
		
		pedidoPLRepository.save(mapper.map(pedido, PedidoPL.class));
		
	}
	
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Pedido> getAll() {
		return pedidoPLRepository.findAll().stream()
				.map(x -> mapper.map(x, Pedido.class))
				.toList();
	}
	
	// ***********************************
	//
	// DTOs
	//
	// ***********************************
	
	@Override
	public List<PedidoDTO1> getPedidosDTO1() {
		return pedidoPLRepository.findDTO1();
	}
	
}
