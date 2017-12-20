package com.example.alex.spring.mongoconfig.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.alex.spring.mongoconfig.entity.SomeStringEntity;

/**
 * @author apa
 */
@Repository
public interface SomeRepository extends MongoRepository<SomeStringEntity, String> {

}
