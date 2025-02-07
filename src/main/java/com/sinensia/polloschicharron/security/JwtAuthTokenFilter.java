package com.sinensia.polloschicharron.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthTokenFilter extends OncePerRequestFilter{

	 @Autowired
	 private JwtUtils jwtUtils;
	 
	 @Autowired
	 private UserDetailsServiceImpl userDetailsService;
	 	 	
	 @Override
	 protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		 
		 try {
			 
			 String token = extractToken(request);
			 
			 if (token != null && jwtUtils.validateJwtToken(token)) {
				 String username = jwtUtils.getUserNameFromJwtToken(token);
				 UserDetails userDetails = userDetailsService.loadUserByUsername(username);
				 UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
	             authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
	             SecurityContextHolder.getContext().setAuthentication(authentication);
			 }
		 
		 } catch (Exception e) {
			 
			 logger.error("Cannot set user authentication: {}", e);
		 }
		 
		 filterChain.doFilter(request, response);
		 
	 }

	 // *************************************************************************************
	 //
	 // PRIVATE METHODS
	 //
	 // *************************************************************************************

	 private String extractToken(HttpServletRequest request) {
	    	
		String headerAuth = request.getHeader("Authorization"); 
	        
		if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
			 return headerAuth.substring(7);
		}
		
		return null;
	}
}
