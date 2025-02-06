package com.sinensia.polloschicharron.auditoria.integration.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sinensia.polloschicharron.auditoria.integration.model.RequestLogPL;

public interface RequestLogPLRepository extends JpaRepository<RequestLogPL, Long> {

}
