package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.DemoRepository;
import com.example.demo.dao.Demo;

@Service
public class DemoService {
	
	@Autowired
	DemoRepository repository;
	
	public List<Demo> getAll() {
		List<Demo> list = repository.findAll();
		return list;		
	}
	
	

}
