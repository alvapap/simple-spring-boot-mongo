package com.example.alex.spring.mongoconfig.app;

import java.net.UnknownHostException;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;
import com.mongodb.ReadPreference;

/**
 * @author apa
 */
@Configuration
@ComponentScan("com.example.alex.databaseconfig")
@EnableMongoRepositories("com.example.alex.databaseconfig.repo")
@EnableConfigurationProperties(MongoProperties.class)
@PropertySource("classpath:application.properties")
public class ApplicationConfig {

	private static MongoTemplate mediaCodeMongoTemplate = null;

	@Bean
	public MongoOperations mongoOperations(MongoProperties properties)
			throws NumberFormatException, UnknownHostException {
		if (mediaCodeMongoTemplate == null) {
			DbRefResolver dbRefResolver = new DefaultDbRefResolver(mongoDbFactory(properties));
			MappingMongoConverter converter = new MappingMongoConverter(dbRefResolver, new MongoMappingContext());
			converter.setTypeMapper(new DefaultMongoTypeMapper(null));

			mediaCodeMongoTemplate = new MongoTemplate(mongoDbFactory(properties), converter);
			mediaCodeMongoTemplate.setReadPreference(ReadPreference.primary());
		}
		return mediaCodeMongoTemplate;
	}

	@Bean(name = "mongoDbFactory")
	public MongoDbFactory mongoDbFactory(MongoProperties properties)
			throws NumberFormatException, UnknownHostException {
		return new SimpleMongoDbFactory(mongoClient(properties), properties.getDatabase());
	}

	@Bean(name = "mongoClient")
	public MongoClient mongoClient(MongoProperties properties) throws UnknownHostException {
		return new MongoClient(properties.getHost()); // new MongoClientURI(properties.getUri())
	}
}
