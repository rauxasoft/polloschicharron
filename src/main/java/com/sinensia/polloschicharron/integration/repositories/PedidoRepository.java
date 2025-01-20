package com.sinensia.polloschicharron.integration.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sinensia.polloschicharron.business.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
