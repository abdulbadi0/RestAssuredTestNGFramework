package apiTestCases;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;


import apiTestClasses.PostsFirstClass;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class JsonLocalServerRequest {
	PostsFirstClass pfc = new PostsFirstClass();
	
	@Test(priority = 1)
	public void get_01() {
		RestAssured.baseURI = "http://localhost:3000/posts";
		RequestSpecification httpRequest = RestAssured.given();

		Response resp = httpRequest.get("");

		ResponseBody resbody = resp.body();

		System.out.println("GET Response is : " + resbody.asString());

	}

	@Test(priority = 2, enabled = false)
	public void post_02() {

		RestAssured.baseURI = "http://localhost:3000";
		RequestSpecification httpRequest = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("id", 14);
		requestParams.put("title", "json-server-mine");
		requestParams.put("author", "ABDULBADI_14");

		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestParams.toJSONString());

		Response resp = httpRequest.post("/posts");
		ResponseBody respbody = resp.body();

		System.out.println("post_02 response is: " + respbody.asString());

	}

	@Test(priority = 0, enabled = false)
	public void testmyPostClass_03() {

		pfc.setID(13);
		pfc.setTitle("Class Title PostsFirstClass_13");
		pfc.setAuthor("Myself_13");

		RestAssured.baseURI = "http://localhost:3000";
		RequestSpecification httpRequest = RestAssured.given();
		// Header acceptheader = new Header("Content-Type", "application/json");
		httpRequest.header("Content-Type", "application/json");

		httpRequest.body(pfc);
		Response resp = httpRequest.post("/posts");
		ResponseBody respbody = resp.body();

		System.out.println("testmyPostClass Response is: " + respbody.asString());

	}

	@Test(enabled = false)
	public void bdd_TC_04() {
		RestAssured.baseURI = "http://localhost:3000";

		Map<String, String> mapbody = new HashMap<>();
		mapbody.put("id", String.valueOf(15));
		mapbody.put("title", "json-server-mine");
		mapbody.put("author", "ABDUL BABA MAP");

		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.header("Content-Type", "application/json");
		Response resp = httpRequest.body(mapbody).when().post("/posts").andReturn();

		System.out.println("BDD way of MAP Post response is :" + resp.asPrettyString());

	}

	@Test(enabled = false)
	public void readFileFromInputAndPost_05() {

		File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\Payloads\\inputMember.json");
		RestAssured.baseURI = "http://localhost:3000";

		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.header("Content-Type", "application/json");
		Response resp = httpRequest.body(file).when().post("/posts").andReturn();

		System.out.println("Input from File Post response is :" + resp.asPrettyString());

	}

	@Test(enabled = false)
	public void readFileAsInputStreamAndPost_06() {

		File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\Payloads\\inputMember.json");
		RestAssured.baseURI = "http://localhost:3000";

		InputStream fis = getClass().getClassLoader().getResourceAsStream("\\Payloads\\inputMember.json");
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.header("Content-Type", "application/json");
		Response resp = httpRequest.body(fis).when().post("/posts").andReturn();

		System.out.println("InputStream getClass().getClassLoader().getResourceAsStream Post response is :"
				+ resp.asPrettyString());

	}

	@Test(enabled = false)
	public void readFileAsByteArrayAndPost_07() throws IOException {

		RestAssured.baseURI = "http://localhost:3000";
		byte[] bytearraybody = Files.readAllBytes(
				Paths.get(System.getProperty("user.dir") + "\\src\\test\\resources\\Payloads\\inputMember.json"));
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.header("Content-Type", "application/json");
		Response resp = httpRequest.body(bytearraybody).when().post("/posts").andReturn();

		System.out.println("Files.readAllBytes(Paths.get(System.getProperty(path of json file) Post response is :" + resp.asPrettyString());

	}

	
}
