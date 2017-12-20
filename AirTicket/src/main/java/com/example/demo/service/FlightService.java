package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.Flight;
import com.example.demo.to.FlightRequest;
import com.example.demo.Repository.FlightRepository;

@Service
public class FlightService {
	
	@Autowired
	FlightRepository flightRepo;
	
	public Map<String,Object> getAllFlights(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("status", "1");
		map.put("message", "Found successfully");
		map.put("flightList", flightRepo.findAll());
		
		return map;
	}

	public Map<String, Object> addAllFlights(FlightRequest[] flights) {
		// TODO Auto-generated method stub
		for(FlightRequest flight : flights) {
			Flight flightDb = new Flight();
			convertFlightRequestToDb(flight,flightDb);
			flightRepo.insert(flightDb);
		}
		return getAllFlights();
	}

	public void convertFlightRequestToDb(FlightRequest flightRequest,Flight flight ) {
		flight.setAirlines(flightRequest.getAirlines());
		flight.setArrivalTime(flightRequest.getArrivalTime());
		flight.setCost(flightRequest.getCost());
		flight.setDeptDate(flightRequest.getDeptDate());
		flight.setDeptTime(flightRequest.getDeptTime());
	}
}





