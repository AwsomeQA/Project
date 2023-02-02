package com.rest;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class TCo1GET {

	public static int id2=getId();
	@Test
	public static void getAllId() {
		// TODO Auto-generated method stub
		RestAssured.baseURI="https://restful-booker.herokuapp.com";
		RequestSpecification request=RestAssured.given();
		Response response=request.get("/booking");
		JsonPath json = response.jsonPath();
		//List<Map<String,Integer>> bookid=json.getList("bookingid");
		//System.out.println(bookid);
		int statuscode=response.getStatusCode();
		System.out.println("statuscode:"+statuscode);
		Assert.assertEquals(statuscode, 200);
		List<Integer> bookersid=json.getList("bookingid");
	
		//int counter=0;
	    
	   
	     for( Integer ids :bookersid)
			{
				
				System.out.println("allbookingid: " + ids);
				//counter++;
				
			}
	}
	       
	
	public static int getId()
	{
		RestAssured.baseURI="https://restful-booker.herokuapp.com";
		RequestSpecification request=RestAssured.given();
		Response response=request.get("/booking");
		JsonPath json = response.jsonPath();
		List<Integer> bookerid=json.getList("bookingid");
	      int id2=bookerid.get(2);
	      System.out.println("second id:"+id2);
	      return id2;
		
	}

}
