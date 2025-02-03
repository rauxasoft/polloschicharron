package com.sinensia.polloschicharron.security.integration.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="USERS", uniqueConstraints = {
		@UniqueConstraint(columnNames = "USERNAME"),
		@UniqueConstraint(columnNames = "EMAIL")
})
public class UsuarioPL implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;
	
	@NotBlank
	@Column(length=50)
	@Size(min=4, max=50)
	private String username;
	
	@NotBlank
	@Size(max=120)
	private String password;
	
	@NotBlank
	@Size(max=150)
	@Email
	private String email;
	
    @Size(min=4, max=50)
    @Column(name = "FIRST_NAME")
    private String firstName;

    @Size(min=4, max=50)
    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(length=50)
    @Size(min = 4, max = 50)
    private String telefono;

    @NotNull
    private Boolean enabled;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastPasswordResetDate;
	
	@ManyToMany
	@JoinTable(name="USER_ROLES", 
	           joinColumns = @JoinColumn(name="ID_USER"), 
	           inverseJoinColumns = @JoinColumn(name="ID_ROL"))
	private Set<RolePL> roles = new HashSet<>();

	public UsuarioPL() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Date getLastPasswordResetDate() {
		return lastPasswordResetDate;
	}

	public void setLastPasswordResetDate(Date lastPasswordResetDate) {
		this.lastPasswordResetDate = lastPasswordResetDate;
	}

	public Set<RolePL> getRoles() {
		return roles;
	}

	public void setRoles(Set<RolePL> roles) {
		this.roles = roles;
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
		UsuarioPL other = (UsuarioPL) obj;
		return Objects.equals(id, other.id);
	}
	
}
