package com.example.demo.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.User;

@Transactional
public interface UserRepository extends MongoRepository<User,String>{

}
