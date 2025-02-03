package com.sinensia.polloschicharron.security.integration.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ROLES")
public class RolePL implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private Role name;

	public RolePL() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Role getName() {
		return name;
	}

	public void setName(Role name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RolePL other = (RolePL) obj;
		return Objects.equals(id, other.id);
	}

}
