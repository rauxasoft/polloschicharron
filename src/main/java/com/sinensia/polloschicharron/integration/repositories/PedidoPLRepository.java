package com.sinensia.polloschicharron.integration.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sinensia.polloschicharron.business.model.dtos.PedidoDTO1;
import com.sinensia.polloschicharron.integration.model.PedidoPL;

public interface PedidoPLRepository extends JpaRepository<PedidoPL, Long> {

	@Query("SELECT new com.sinensia.polloschicharron.business.model.dtos.PedidoDTO1(              "
		 + "       p.id,                                                                          "
		 + "       p.fechaHora,                                                                   "
		 + "       p.establecimiento.nombre,                                                      "
		 + "       UPPER(CONCAT(p.empleado.apellido1,                                             "
		 + "                    COALESCE(CONCAT(' ', p.empleado.apellido2), ''),                  "
		 + "                    ', ',                                                             "
		 + "                    p.empleado.nombre)),                                              "
		 + "       CASE WHEN p.estado = EstadoPedidoPL.NUEVO THEN 'NUEVO'                         "
		 + "            WHEN p.estado = EstadoPedidoPL.EN_PROCESO THEN 'EN_PROCESO'               "
		 + "            WHEN p.estado = EstadoPedidoPL.PENDIENTE_ENTREGA THEN 'PENDIENTE_ENTREGA' "
		 + "            WHEN p.estado = EstadoPedidoPL.SERVIDO THEN 'SERVIDO'                     "
		 + "            WHEN p.estado = EstadoPedidoPL.CANCELADO THEN 'CANCELADO'                 "
		 + "          	ELSE NULL                                                                 "
		 + "        END )                                                                         "
		 + "FROM   PedidoPL p                                                                     ")
	List<PedidoDTO1> findDTO1();

} 
