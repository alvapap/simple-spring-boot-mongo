package com.example.alex.spring.mongoconfig.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author apa
 */
@Document(collection = "collectionName")
public class SomeStringEntity {

	@Id
	private String	id;

	private String	someString;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSomeString() {
		return someString;
	}

	public void setSomeString(String someString) {
		this.someString = someString;
	}

}
