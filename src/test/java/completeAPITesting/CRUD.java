package completeAPITesting;

import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CRUD {

	@Test
	public void Test_01() {

		RestAssured.baseURI = "https://api.postman.com";
		RequestSpecification httpRequest = RestAssured.given();
		Header second = new Header("x-api-key", "PMAK-639b107fd1bfba31e82342d0-6f8005f28c75b4f03db19b4b61153b1657");
		Headers headerMy = new Headers(second);
		httpRequest.headers(headerMy);
		Response resp = httpRequest.get("/workspaces");
		// ResponseBody resbody = resp.getBody();
		String str = resp.asPrettyString();
		System.out.println(str);
		int code = resp.getStatusCode();
		System.out.println(resp.getStatusCode());
		System.out.println(resp.getStatusLine());
		Assert.assertEquals(code, 200, "Coming expected code");
		System.out.println("extracting one particular node: " + resp.path("workspaces[0].name"));
		
		//assertThat("","");
	}
}
