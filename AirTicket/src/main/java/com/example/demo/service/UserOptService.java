package com.example.demo.service;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.UserBookingRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.dao.User;
import com.example.demo.dao.UserBooking;
import com.example.demo.to.UserBookingRequest;
import com.example.demo.util.DateUtils;

@Service
public class UserOptService {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	UserBookingRepository userBookingRepo;
	
	
	public Map<String,Object> saveUser(User user) {
		
		Map<String,Object> map = new HashMap<String,Object>();
		String emailAddr =null;
		if(user!=null) {
			emailAddr = user.getEmailAddress();
			User userDb = userRepo.findOne(emailAddr);
			if(userDb!=null && userDb.getEmailAddress().equalsIgnoreCase(emailAddr)) {
				map.put("status", "0");
				map.put("message", "Existing user. Please log in");
			}else {
				User userNew = userRepo.insert(user);
				map.put("status", "1");
				map.put("message", "successfully Registered");
				map.put("user", userNew);
			}
		}else {
			map.put("status", "-1");
			map.put("message", "invalid");
		}
		return map;
	}
	
	public List<User> getAllUsers(){
		
		List<User> list = userRepo.findAll();
		return list;
	}
	
	public Map<String,Object> getUserByEmail(String emailAddress, String password) {
		
		Map<String,Object> map = new HashMap<String,Object>();
		User user = userRepo.findOne(emailAddress);
		if(user!=null && user.getPassword().equals(password)) {
			map.put("status", "1");
			map.put("message", "Sucess");
			map.put("user", user);
		}else {
			map.put("status", "0");
			map.put("message", "Invalid user. Please register and then login");
		}
		return map;
	}
	
	
	
	/****************Landing page****************/
	public Map<String,Object> booking(UserBookingRequest[] userBookingRequest) {
		
		String emailAddress = null;
		Map<String,Object> map = new HashMap<String,Object>();
		for (UserBookingRequest userBook : userBookingRequest) {
			UserBooking userBookingdb = new UserBooking();
			convertRequestToDb(userBook,userBookingdb);
			userBookingRepo.insert(userBookingdb);
			emailAddress = userBook.getEmailAddress();
		}
		
		List<UserBooking> list = getBookingByEmail(emailAddress);//userBookingRepo.findAll();
		
		map.put("status", "1");
		map.put("message", "Sucess");
		map.put("bookingList", list);
		
		return map;
		
		
	}
	
	
	public Map<String,Object> cancel(String emailAddress, String airlines){
		Map<String,Object> map = new HashMap<String,Object>();
		
		userBookingRepo.deleteByEmailAndAirline(emailAddress, airlines); //To be updated
		List<UserBooking> list = getBookingByEmail(emailAddress);//userBookingRepo.findAll();
		
		map.put("status", "1");
		map.put("message", "Sucess");
		map.put("bookingList", list);
		
		return map;
		
	}
	
	public Map<String,Object> showBooking(String emailAddress){
		
		List<UserBooking> list = getBookingByEmail(emailAddress);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("status", "1");
		map.put("message", "Sucess");
		map.put("bookingList", list);
		
		return map;
		
	}
	
	
	
	
	
	
	
	
	/*************************Additional Function******/
	
	public List<UserBooking> getBookingByEmail(String emailAddress){
		return userBookingRepo.findByEmail(emailAddress);
	}
	
	public void deleteAllBooking(){
		
		userBookingRepo.deleteAll();
		
		
	}
	
	
	
	

	
	private void convertRequestToDb(UserBookingRequest userRequest, UserBooking userBookDb) {
		
		userBookDb.setAirlines(userRequest.getAirlines());
		userBookDb.setArrivalTime(userRequest.getArrivalTime());
		userBookDb.setDepartDate(userRequest.getDepartDate());
		userBookDb.setDepartTime(userRequest.getDepartTime());
		userBookDb.setEmailAddress(userRequest.getEmailAddress());
		userBookDb.setPassCount(userRequest.getPassCount());
		userBookDb.setTotalCost(userRequest.getTotalCost());
		
	}

}
