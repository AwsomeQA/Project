package com.rest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TCo3CreateUser {
	
	public static void main(String[] args) {
		String reqbody="{\r\n"
				+ "    \"firstname\" : \"Arati\",\r\n"
				+ "    \"lastname\" : \"Mishra\",\r\n"
				+ "    \"totalprice\" : 1501,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2022-04-01\",\r\n"
				+ "        \"checkout\" : \"2022-04-07\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
				+ "}";
		RestAssured.baseURI="https://restful-booker.herokuapp.com";
		String response=given().contentType(ContentType.JSON).body(reqbody).when().post("/booking").then().log().all().assertThat().statusCode(200).extract().response().asString();
		System.out.println(response);
	}

}
