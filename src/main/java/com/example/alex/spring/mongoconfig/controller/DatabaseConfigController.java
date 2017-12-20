package com.example.alex.spring.mongoconfig.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.alex.spring.mongoconfig.entity.SomeStringEntity;
import com.example.alex.spring.mongoconfig.service.SomeService;

/**
 * @author apa
 */
@RestController
public class DatabaseConfigController {

	@Autowired
	private SomeService service;

	@GetMapping("/repo1")
	public ResponseEntity<List<SomeStringEntity>> getAllStrings() {
		List<SomeStringEntity> response = service.getAllStrings();
		return new ResponseEntity<List<SomeStringEntity>>(response, HttpStatus.OK);
	}

	@GetMapping("/repo2")
	public ResponseEntity<List<SomeStringEntity>> getSomeStrings() {
		List<SomeStringEntity> response = service.getSomeStrings();
		return new ResponseEntity<List<SomeStringEntity>>(response, HttpStatus.OK);
	}

}
