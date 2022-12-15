package testCases;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
	
	@BeforeSuite
	public void setup() {
		System.out.println("Initializing everything...");
	}
	
	@AfterSuite
	public void tearDown() {
		System.out.println("Quiting everything...");
	}

}
