package apiTestCases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class SuccesAndFailureResponses {

	@Test
	public void userRegistrationUnSuccessful() {
		RestAssured.baseURI = "https://demoqa.com";

		RequestSpecification httprequest = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("UserName", "test_rest");
		requestParams.put("Password", "rest@123");

		httprequest.body(requestParams.toJSONString());

		Response resp = httprequest.post("/Account/v1/User");

		ResponseBody body = resp.getBody();
		// Deserialize the Response body into JSONSuccessResponse

		JSONFailureResponse responseBody = body.as(JSONFailureResponse.class);

		// Use the JSONSuccessResponseclass instance to Assert the values of Response.

		Assert.assertEquals("1200", responseBody.code, "Code is correct");
		Assert.assertEquals("UserName and Password required.", responseBody.message, "Message is correct");

		System.out.println("StatusCode: " + resp.getStatusCode());
		System.out.println("StatusLine: " + resp.getStatusLine());

		System.out.println("POJO Class JSONFailureResponse TC Validated successfully");

	}

	@Test
	public void getUserID() {
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

		RequestSpecification httprequest = RestAssured.given();

		Response resp = httprequest.get("/todos/1");

		ResponseBody body = resp.getBody();
		// Deserialize the Response body into JSONSuccessResponse

		JSONSuccessResponse responseBody = body.as(JSONSuccessResponse.class);

		// Use the JSONSuccessResponseclass instance to Assert the values of Response.
		Assert.assertEquals(1, responseBody.userId, "userId is correct");
		Assert.assertEquals(1, responseBody.id, "id is correct");
		Assert.assertEquals("delectus aut autem", responseBody.title, "title is correct");
		Assert.assertEquals(false, responseBody.completed, "Code is correct");
		System.out.println("StatusCode: " + resp.getStatusCode());
		System.out.println("StatusLine: " + resp.getStatusLine());

		System.out.println("POJO Class JSONSuccessResponse TC Validated successfully");

	}

}
