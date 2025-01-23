package com.sinensia.polloschicharron.integration.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sinensia.polloschicharron.business.model.Pedido;
import com.sinensia.polloschicharron.business.model.dtos.PedidoDTO1;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	@Query("SELECT new com.sinensia.polloschicharron.business.model.dtos.PedidoDTO1( "
		 + "       p.id,                                                             "
		 + "       p.fechaHora,                                                      "
		 + "       p.establecimiento.nombre,                                         "
		 + "       UPPER(CONCAT(p.empleado.apellido1,                                "
		 + "                    COALESCE(CONCAT(' ', p.empleado.apellido2), ''),     "
		 + "                    ', ',                                                "
		 + "                    p.empleado.nombre)),                                 "
		 + "       p.estado)                                                         "
		 + "FROM   Pedido p                                                          ")
	List<PedidoDTO1> findDTO1();

} 
