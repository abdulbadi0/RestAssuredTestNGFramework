package testDataParametrization;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestParamsFromXMLNG {
	
	@Parameters({"browser","env"})
	@Test
	public void browserfile(String browser, String env) {
		System.out.println(browser + " " +env);
		
	}
	

}
