package com.example.alex.spring.mongoconfig.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.alex.spring.mongoconfig.entity.SomeStringEntity;
import com.example.alex.spring.mongoconfig.repo.SomeMongoTemplateRepo;
import com.example.alex.spring.mongoconfig.repo.SomeRepository;

/**
 * @author apa
 */
@Service
public class SomeServiceImpl implements SomeService {

	@Autowired
	SomeRepository			someRepo;

	@Autowired
	SomeMongoTemplateRepo	mongoTeplateRepo;

	@Override
	public List<SomeStringEntity> getAllStrings() {
		List<SomeStringEntity> allStrings = someRepo.findAll();
		return allStrings;
	}

	@Override
	public List<SomeStringEntity> getSomeStrings() {
		List<SomeStringEntity> allStrings = mongoTeplateRepo.findSome();
		return allStrings;
	}

}
