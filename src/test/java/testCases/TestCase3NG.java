package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase3NG  extends BaseTest{

	@Test(priority = 1,groups = "smoke")
	public void userRegistration() {
		System.out.println("Executing userRegistration test...");
		Assert.fail("Not registered");
	}

	@Test(priority = 2, dependsOnMethods = "userRegistration",groups = {"functional,smoke"})
	public void doLogin() {
		System.out.println("Executing Login test....");
	}

	@Test(priority = 3, dependsOnMethods = "userRegistration", alwaysRun = true,groups = {"functional,smoke"})
	public void thirdTest() {
		System.out.println("Executing 3rd test....");
	}

	@Test(priority = 4,groups = {"bvt"})
	public void fourthTest() {
		System.out.println("Executing 4th test....");
	}
}
