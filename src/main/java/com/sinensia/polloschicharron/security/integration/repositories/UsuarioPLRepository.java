package com.sinensia.polloschicharron.security.integration.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sinensia.polloschicharron.security.integration.model.UsuarioPL;

public interface UsuarioPLRepository extends JpaRepository<UsuarioPL, Long>{

	Optional<UsuarioPL> findByUsername(String username);
}
