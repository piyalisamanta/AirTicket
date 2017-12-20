package com.example.demo.controller;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.dao.Flight;
import com.example.demo.dao.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.DemoService;
import com.example.demo.service.FlightService;
import com.example.demo.service.UserOptService;
import com.example.demo.to.FlightRequest;
import com.example.demo.to.UserBookingRequest;

@RestController
@RequestMapping("/demo")
public class UserController {
	
	@Autowired
	private UserOptService userService;
	
	
	@Autowired
	private FlightService flightService;
	
	/*@CrossOrigin
	@RequestMapping("/all")
	public Map<String,Object> getAll(){		
		Map<String,Object> map = new HashMap<String, Object>();		
		return (Map<String, Object>) map.put("demos", demoService.getAll());
	}
	*/
	
	@CrossOrigin
	@PutMapping("/register")
	public Map<String,Object> saveUser(@RequestBody User user){
		
		return userService.saveUser(user);
		
	}
	
	@CrossOrigin
	@RequestMapping("/findAll")
	public List<User> getAllUser() {
		return  userService.getAllUsers();
	}
	
	@CrossOrigin
	@RequestMapping("/login")
	public Map<String,Object> login(@RequestParam String emailAddress, @RequestParam String password){
		return userService.getUserByEmail(emailAddress,password);
	}
	
	
	@CrossOrigin
	@PutMapping("/booking")
	public Map<String,Object> booking(@RequestBody UserBookingRequest[] userbookingRequest){
		return userService.booking(userbookingRequest);
	}
	
	@CrossOrigin
	@RequestMapping("/cancel")
	public Map<String,Object> cancel(@RequestParam String emailAddress, @RequestParam String airlines){
		return userService.cancel(emailAddress,airlines);
	}
	
	@CrossOrigin
	@RequestMapping("/showBooking")
	public Map<String,Object> showBooking(@RequestParam String emailAddress){
		return userService.showBooking(emailAddress);
	}
	
	
	
	@CrossOrigin
	@RequestMapping("/findFlights")
	public Map<String,Object> getFlights(){
		return flightService.getAllFlights();
	}
	
	@CrossOrigin
	@RequestMapping("/addFlight")
	public Map<String,Object> addFlights(@RequestBody FlightRequest[] flights){
		return flightService.addAllFlights(flights);
	}
	
	
	@CrossOrigin
	@RequestMapping("/deleteAllBooking")
	public void deleteAllBooking(){
		 userService.deleteAllBooking();
	}

}
