package com.rest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class NonStaticImports {
	@Test
	public void Test() {
		// Write the code to read JSON from the response.
		RestAssured.baseURI = "https://26d884b2-5589-489f-8e12-f6bd4d0544f1.mock.pstmn.io";
		RequestSpecification httpRequest = RestAssured.given();
		Header first = new Header("x-mock-response-code", "200");
		Header second = new Header("x-api-key", "PMAK-639b107fd1bfba31e82342d0-6f8005f28c75b4f03db19b4b61153b1657");
		Headers headerMy = new Headers(first, second);
		httpRequest.headers(headerMy);
		Response resp = httpRequest.get("/get");
		//ResponseBody resbody = resp.getBody();
		String str = resp.asPrettyString();
		System.out.println(str);
		
		// First get the JsonPath object instance from the Response interface
		
		JsonPath jsonP = resp.jsonPath();
		
		String name = jsonP.get("name");
		System.out.println("Name json path is : "+name);
	//	Assert.assertEquals(, null)

	}
}
