package com.sinensia.polloschicharron.security;

import java.io.IOException;
import java.io.PrintWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sinensia.polloschicharron.presentation.config.HttpErrorCustomizado;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthEntryPoint implements AuthenticationEntryPoint{

	private static final Logger logger = LoggerFactory.getLogger(JwtAuthEntryPoint.class);
    
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
    	
    	logger.error("Unauthorized error: {}", authException.getMessage());
    
    	HttpErrorCustomizado httpErrorCustomizado = new HttpErrorCustomizado(authException.getMessage());
    	
    	response.setContentType("application/json");
    	response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    	
    	PrintWriter out = response.getWriter();
    	out.print(objectMapper.writeValueAsString(httpErrorCustomizado));
    	
    	out.close();
    	
    }

}
