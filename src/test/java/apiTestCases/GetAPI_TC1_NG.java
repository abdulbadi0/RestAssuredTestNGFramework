package apiTestCases;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class GetAPI_TC1_NG {
	@Test
	public void testGetAPI() {

		RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";

		RequestSpecification httpRequest = RestAssured.given();

		Response resp = httpRequest.request(Method.GET, "");

		System.out.println("Status recieved:-  " + resp.getStatusLine());
		System.out.println("Response is:-  " + resp.prettyPrint());

	}

	@Test
	public void validateResponseStatus() {

		RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";

		RequestSpecification httpRequest = RestAssured.given();

		Response resp = httpRequest.get("");

		int scode = resp.getStatusCode();
		System.out.println("Status recieved:-  " + scode);
		Assert.assertEquals(scode, 200, "correct statuscode is returned.");

	}

	@Test
	public void validateResponseHeader() {

		RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";

		RequestSpecification httpRequest = RestAssured.given();

		Response resp = httpRequest.get("");

		Headers allheaders = resp.getHeaders();

		for (Header header : allheaders) {
			System.out.println("Key: " + header.getName() + " and Value: " + header.getValue());
		}
	}

	@Test
	public void readJsonBody() {

		RestAssured.baseURI = "https://demoqa.com/BookStore/v1";

		RequestSpecification httpRequest = RestAssured.given();

		Response resp = httpRequest.get("/Books");

		ResponseBody body = resp.getBody();

		System.out.println("Response Body is:---  " + body.asString());

		String bodyAsString = body.asString();
		Assert.assertEquals(bodyAsString.contains("Git Pocket Guide"), true, "Response body containsGit Pocket Guide ");
		// Assert.assertEquals(bodyAsString.toLowerCase().contains("Git Pocket Guide"),
		// true, "Response body containsGit Pocket Guide ");

	}

	@Test
	public void verifybooksinJsonResponse() {

		RestAssured.baseURI = "https://demoqa.com/BookStore/v1";

		RequestSpecification httpRequest = RestAssured.given();

		Response resp = httpRequest.get("/Books");

		JsonPath jsonpathEvaluator = resp.jsonPath();

		ArrayList list = new ArrayList<>();

		list.add(jsonpathEvaluator.get("books"));

		Iterator itr = list.iterator();

		while (itr.hasNext()) {

			if (list.contains("Richard E. Silverman")) {
				System.out.println("JsonKey is available:- " + itr.next());
			} else {
				System.out.println("JsonKey is Not available:- " + itr.next());
			}

		}

		// jsonpathEvaluator.get("books");//null value
		// System.out.println("JsonKey is vailable:- " + verifyBooksPresent);
		// Assert.assertEquals(verifyBooksPresent, "books","Correct book name is
		// present");
	}

	@Test
	public void queryParameter() {

		// Defining the base URI
		RestAssured.baseURI = "https://demoqa.com/BookStore/v1";
		// Defining the RequestSpecification of restAssured class
		RequestSpecification httpRequest = RestAssured.given();
		// Passing the resource details
		Response resp = httpRequest.queryParam("ISBN", "9781449325862").get("/Book");
		// Retrieving the response body using getBody() method
		ResponseBody rbody = resp.body();
		// Converting the response body to string object
		String strbdy = rbody.asString();
		// Creating object of JsonPath and passing the string response body as parameter
		JsonPath jsp = new JsonPath(strbdy);
		// Storing publisher name in a string variable
		String title = jsp.getString("title");
		System.out.println("The book title is - " + title);
		String subTitle = jsp.getString("subTitle");
		System.out.println("The book subTitle is - " + subTitle);

		String author = jsp.getString("author");
		System.out.println("The book author is - " + author);

	}

	@Test
	public void displayAllNodesInAPI() {

		RestAssured.baseURI = "https://demoqa.com/BookStore/v1";

		RequestSpecification httpRequest = RestAssured.given();

		Response resp = httpRequest.get("/Books");

		JsonPath jsonpathEvaluator = resp.jsonPath();

		System.out.println("books received from Response " + jsonpathEvaluator.get("books"));

	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("It is before Test");

	}

	@AfterTest
	public void afterTest() {
		System.out.println("It is After Test");
	}

}
