package com.flightbookingsystem.flightsearch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flightbookingsystem.flightsearch.model.FlightSearch;
import com.flightbookingsystem.flightsearch.repository.FlightSearchRepository;


@RestController
public class FlightSearchController {
	
	@Autowired
	FlightSearchRepository flightSearchRepository;

	// add flights
	@PostMapping("/search")
	public FlightSearch postFlightSearch(@RequestBody FlightSearch flightsearch) {
		return flightSearchRepository.save(flightsearch);
	}
	
	//method to get all flights
	@GetMapping("/search")
	public List<FlightSearch> getAllflights(){
		List<FlightSearch> flights= flightSearchRepository.findAll();
		return flights;
	}

}
