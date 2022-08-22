package com.flightbookingsystem.flightsearch;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.flightbookingsystem.flightsearch.controller.FlightSearchController;
import com.flightbookingsystem.flightsearch.model.FlightSearch;
import com.flightbookingsystem.flightsearch.repository.FlightSearchRepository;

@SpringBootTest(classes= {FlightSearchMockitoTests.class})
public class FlightSearchMockitoTests {
	
	@Mock
	FlightSearchRepository flightrepo;
	
	@InjectMocks
	FlightSearchController flightController;
	
	
	public List<FlightSearch> myflights;
	
	
	@Test  //test to get all the flights data
	@Order(1)  ////providing the sequence to run the tests
	public void test_getAllflights()
	{
		List<FlightSearch> myflights=new ArrayList<FlightSearch>();
		//adding our own data
		myflights.add(new FlightSearch(1,"Indigo","1092","11-08-22","MUMBAI","BANGALORE",12000));
		myflights.add(new FlightSearch(2,"SpiceJet","1234","14-03-22","DELHI","CHENNAI",13000));
		
		//mock the external dependency i.e whenever the method getAllFlights() is called it will return this data 
		//it will not have to go to the the database
		when(flightrepo.findAll()).thenReturn(myflights);
		assertEquals(2,flightController.getAllflights().size());;
	}
	
	@Test
	@Order(2)
	public void test_addFlights()
	{
		FlightSearch flightSearch = new FlightSearch(3,"AirIndia","3456","18-12-22","SURAT","INDORE",7000);
		//mock external dependency
		
		when(flightrepo.save(flightSearch)).thenReturn(flightSearch);
		assertEquals(flightSearch, flightController.postFlightSearch(flightSearch));
	}

}
