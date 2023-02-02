package com.rest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class TCo2FilterUser  {
	
	//static int userid=TCo1GET.id2;
	@Test
	public static void getspecificUser()
	
	{
		 
		//System.out.println(userid);
		RestAssured.baseURI="https://restful-booker.herokuapp.com";
		RequestSpecification request=RestAssured.given();
		Response response=request.get("/booking/1");
		JsonPath json = response.jsonPath();
		int statuscode=response.getStatusCode();
		String body=response.getBody().asPrettyString();
		System.out.println("body of the response:"+ body);
		System.out.println("statuscode:"+statuscode);
		Assert.assertEquals(statuscode, 200);
	}

}
