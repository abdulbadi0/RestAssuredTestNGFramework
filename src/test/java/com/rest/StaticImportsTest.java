package com.rest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class StaticImportsTest {
  @Test
  public void simple_TC() {
	  
	  given().
	  		baseUri("https://26d884b2-5589-489f-8e12-f6bd4d0544f1.mock.pstmn.io").
	  //		header("x-api-key", "PMAK-639b107fd1bfba31e82342d0-6f8005f28c75b4f03db19b4b61153b1657").
	  		header("x-mock-response-code", 200).
	  		when().
	  			get("/get")
	  			.then()
	  			.statusCode(200)
	  			.body("name", is(equalTo("Successful")));
	  
	  
	  			
  }
}
