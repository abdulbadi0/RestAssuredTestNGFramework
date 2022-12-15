package regression;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase1NG {

	@BeforeTest
	public void creatingDBConnection() {
		System.out.println("Establish DB Connecion");

	}

	@AfterTest
	public void closingDBConnection() {
		System.out.println("losing DB Connecion");

	}

	@BeforeMethod
	public void launchBrowser() {
		System.out.println("Launching browser...");

	}

	@AfterMethod
	public void closingBrowser() {
		System.out.println("Closing browser...");

	}

	@Test(priority = 1)
	public void userRegistration() {
		System.out.println("Executing userRegistration test...");
	}

	@Test(priority = 2)
	public void doLogin() {
		System.out.println("Executing Login test....");
	}

}
