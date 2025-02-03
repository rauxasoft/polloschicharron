package com.sinensia.polloschicharron.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sinensia.polloschicharron.security.integration.model.UsuarioPL;

public class UserDetailsImpl implements UserDetails{
	private static final long serialVersionUID = 1L;

	private Long id;
	private String username;
	
	@JsonIgnore
	private String password;
	
	private String firstName;
	private String lastName;
	private String email;
	private boolean enabled;
	private Collection<? extends GrantedAuthority> authorities;
	
	private UserDetailsImpl(Long id,
			   			    String username,
			   			    String password,
                            String firstName,
                            String lastName,
                            String email,
                            boolean enabled,
                            Collection<? extends GrantedAuthority> authorities) {

				this.id = id;
				this.username = username;
				this.password = password;
				this.firstName = firstName;
				this.lastName = lastName;
				this.email = email;
				this.enabled = enabled;
				this.authorities = authorities;
	}
	
	public static UserDetailsImpl build(UsuarioPL usuarioPL) {
		
		List<GrantedAuthority> roles = usuarioPL.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());
		
		return new UserDetailsImpl(usuarioPL.getId(), 
								   usuarioPL.getUsername(),
								   usuarioPL.getPassword(),
								   usuarioPL.getFirstName(),
								   usuarioPL.getLastName(),
								   usuarioPL.getEmail(),
								   usuarioPL.getEnabled(),
								   roles);
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}
	
	@Override
    public boolean isEnabled() {
        return enabled;
    }

    public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}



}
