package com.flightbookingsystem.flightsearch.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flightbookingsystem.flightsearch.model.AuthRequestModel;




@RestController
public class SecurityController {

	@RequestMapping(value = "info", method = RequestMethod.GET)
	public String info() {
		return "the application is up";
	}

	@RequestMapping(value = "hello", method = RequestMethod.GET)
	public String hello() {
		return "Hello PXP!";
	}
	
	

}
