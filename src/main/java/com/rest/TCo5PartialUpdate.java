package com.rest;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBody;

public class TCo5PartialUpdate {
	@Test
	public void partialUserUp() {
		
		RestAssured.baseURI="https://restful-booker.herokuapp.com";
		//get token
		String tbody="{\r\n"
		+ "    \"username\" : \"admin\",\r\n"
		+ "    \"password\" : \"password123\"\r\n"
		+ "}";
		ResponseBody response=given().contentType(ContentType.JSON).body(tbody).when().post("/auth").then().log().all().assertThat().statusCode(200).extract().response();
		System.out.println(response);
		String rbody=response.asString();
		JsonPath jpath=new JsonPath(rbody);
		String token=jpath.get("token");
		System.out.println(token);
		//update user
		String body="{\r\n"
				+ "    \"firstname\" : \"Jonaki\",\r\n"
				+ "    \"lastname\" : \"Poka\"\r\n"
				+ "}";


		String response1=given().body(body).contentType(ContentType.JSON).cookie("token",token).when().patch("/booking/1").then().log().all().assertThat().statusCode(200).extract().response().asString();
		System.out.println(response1);
		
	}

}
