package com.example.alex.spring.mongoconfig.service;

import java.util.List;

import com.example.alex.spring.mongoconfig.entity.SomeStringEntity;

/**
 * @author apa
 */
public interface SomeService {

	List<SomeStringEntity> getAllStrings();

	List<SomeStringEntity> getSomeStrings();
}
