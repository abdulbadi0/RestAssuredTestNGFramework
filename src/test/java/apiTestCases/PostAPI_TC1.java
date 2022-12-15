package apiTestCases;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostAPI_TC1 {

	@Test
	public void userRegistrationSuccessful() {

		RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
		RequestSpecification httpRequest = RestAssured.given();
		// JSONObject is a class that represents a Simple JSON.

		JSONObject requestparams = new JSONObject();
		requestparams.put("userId", "TQ123");
		requestparams.put("isbn", "9781449325862");

		// Add a header stating the Request body is a JSON

		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestparams.toJSONString());
		Response resp = httpRequest.post("/BookStoreV1BooksPost");
		System.out.println("Stattus is: " + resp.getStatusLine());
		System.out.println("Response is: " + resp.asPrettyString());

	}
}
