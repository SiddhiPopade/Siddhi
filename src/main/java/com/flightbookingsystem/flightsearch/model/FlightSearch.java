package com.flightbookingsystem.flightsearch.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FlightSearch {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	 long id;
	 String flightName;
	 String flightNumber;
	 String flightDate;
	 String origin;
	 String destination;
	 int fare;
	 
	public FlightSearch() {
		super();
		// TODO Auto-generated constructor stub
	}

    // constructor using fields
	public FlightSearch(long id, String flightName, String flightNumber, String flightDate, String origin,
			String destination, int fare) {
		super();
		this.id = id;
		this.flightName = flightName;
		this.flightNumber = flightNumber;
		this.flightDate = flightDate;
		this.origin = origin;
		this.destination = destination;
		this.fare = fare;
	}

	//getters and setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
	}


	@Override
	public String toString() {
		return "FlightSearch [id=" + id + ", flightName=" + flightName + ", flightNumber=" + flightNumber
				+ ", flightDate=" + flightDate + ", origin=" + origin + ", destination=" + destination + ", fare="
				+ fare + "]";
	}
	
	 
	 
	
	
	

}


