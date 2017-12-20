package com.example.demo.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.Demo;

@Transactional
public interface DemoRepository extends MongoRepository<Demo,String>{

}
