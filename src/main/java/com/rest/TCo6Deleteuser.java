package com.rest;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class TCo6Deleteuser {
	@Test
	public void DeleteUser()
	{
		RestAssured.baseURI="https://restful-booker.herokuapp.com";
		String response1=given().contentType(ContentType.JSON).header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=").when().delete("/booking/3").then().log().all().assertThat().statusCode(201).extract().response().asString();
		System.out.println(response1);
		
		
	}

}
