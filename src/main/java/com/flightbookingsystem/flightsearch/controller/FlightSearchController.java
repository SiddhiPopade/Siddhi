package com.flightbookingsystem.flightsearch.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.flightbookingsystem.flightsearch.model.FlightSearch;
import com.flightbookingsystem.flightsearch.repository.FlightSearchRepository;

import io.swagger.annotations.ApiOperation;


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
		return  flightSearchRepository.findAll();
		
	}
	
	@GetMapping("/search/{id}")
	@ApiOperation(value="get flight by id", response=FlightSearch.class)
	public Optional<FlightSearch> getByFlightId(@PathVariable("id") long id){
		return flightSearchRepository.findById(id);
	}
	
	@GetMapping("/search/origin/{origin}")
	public List<FlightSearch> getFlightByOrigin(@PathVariable("origin") String origin){
		return flightSearchRepository.getFlightByOrigin(origin);
	}
	
	@GetMapping("/search/destination/{destination}")
	public List<FlightSearch> getFlightByDestination(@PathVariable("destination") String destination){
		return flightSearchRepository.getFlightByDestination(destination);
	}
	
	/*@GetMapping("/search/{id}")
	public FlightSearch getFilghtById(Long id) throws Exception {
		Optional<FlightSearch> findById =  flightSearchRepository.findById(id);
		if(findById.isPresent()) {
			return findById.get();
		}else {
			throw new Exception("Flight with id:" + id + "does not exists");
			
		}
			
	}*/
	
	//method to update the flight details
	@PutMapping("/update/{id}")
		public FlightSearch updateFlight(@PathVariable("id") long id, @RequestBody FlightSearch search) {
		FlightSearch searchdb = flightSearchRepository.getById(id);
		searchdb.setBusinessClassFare(search.getBusinessClassFare());
		searchdb.setDestination(search.getDestination());
		searchdb.setEconomyClassFare(search.getEconomyClassFare());
		searchdb.setFlightDate(search.getFlightDate());
		searchdb.setFlightName(search.getFlightName());
		searchdb.setFlightTime(search.getFlightTime());
		searchdb.setOrigin(search.getOrigin());
		
		return flightSearchRepository.save(searchdb);
		}
	
	//method to delete flights
	@DeleteMapping("/delete/{id}")
	public void deleteFlight(@PathVariable("id") long id) {
		flightSearchRepository.deleteById(id);
	}

}
