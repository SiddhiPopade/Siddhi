package com.flightbookingsystem.flightsearch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightbookingsystem.flightsearch.model.FlightSearch;

public interface FlightSearchRepository extends JpaRepository<FlightSearch, Long>  {

}
