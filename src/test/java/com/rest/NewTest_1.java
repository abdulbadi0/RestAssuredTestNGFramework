package com.rest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class NewTest_1 {
	
  @Test
  public void Test() {
	  RestAssured.given();
	  given().
	  when().then();
	 
	  
  }
}
