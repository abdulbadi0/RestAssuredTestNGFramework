package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestCase2NG extends BaseTest {

	@Test(groups = {"functional,smoke"})
	public void validateTitles() {
		System.out.println("Begining....");
		String actual = "Google.com";
		String expected = "Yahoo.com";

		SoftAssert sa = new SoftAssert();

		if (actual.equals(expected)) {
			System.out.println("Test  case pass");
		} else {
			System.out.println("Test case fail");
		}

		System.out.println("Validating strings value");
		sa.assertEquals(actual, expected);
		System.out.println("Validating elements value");
		sa.assertTrue(false, "Element not found");
		System.out.println("Failing intentionally");
		sa.fail("Failing test as condition is not met");

		// Hard Assertion: break the code here only
		// Assert.assertEquals(actual, expected);
		// Assert.assertTrue(false, "Element not found");
		// Assert.fail("Failing test as condition is not met");
		System.out.println("Ending.....");

		sa.assertAll();
	}

}
