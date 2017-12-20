package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.UserBooking;

@Transactional
public interface UserBookingRepository extends MongoRepository<UserBooking, String>{
	
	@Query(value="{emailAddress: ?0,airlines: ?1}",delete=true)
	public Long deleteByEmailAndAirline(String emailAddress, String airlines);
	
	@Query(value="{emailAddress: ?0}")
	public List<UserBooking> findByEmail(String emailAddress);

}
