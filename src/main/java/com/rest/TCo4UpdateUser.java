package com.rest;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;


public class TCo4UpdateUser {

	public static void main(String[] args) {
		RestAssured.baseURI="https://restful-booker.herokuapp.com";
		
		
		String body="{\r\n"
				+ "    \"firstname\" : \"Jack\",\r\n"
				+ "    \"lastname\" : \"hui\",\r\n"
				+ "    \"totalprice\" : 11100,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2023-01-01\",\r\n"
				+ "        \"checkout\" : \"2019-01-02\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
				+ "}";


		String response1=given().body(body).contentType(ContentType.JSON).header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=").when().put("/booking/1").then().log().all().assertThat().statusCode(200).extract().response().asString();
		System.out.println(response1);
		

	}

}
