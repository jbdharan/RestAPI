package com.country.framework;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.http.ContentType;

public class base {
	public void configure(){
	RestAssured.baseURI ="https://restcountries.eu/rest/v2/all";

	}
	
public RequestSpecification getRequestSpecification(){
	return RestAssured.given().contentType(ContentType.JSON);
}
}
