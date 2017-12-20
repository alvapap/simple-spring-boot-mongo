package com.example.alex.spring.mongoconfig.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import com.example.alex.spring.mongoconfig.entity.SomeStringEntity;

/**
 * @author apa
 */
@Repository
public class SomeMongoTemplateRepo {

	@Autowired
	private MongoOperations mongoOperations;

	public List<SomeStringEntity> findSome() {
		List<SomeStringEntity> findSomeResult = mongoOperations.findAll(SomeStringEntity.class);
		return findSomeResult;
	}
}
