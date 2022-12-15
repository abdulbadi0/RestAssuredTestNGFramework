package parallelTest;

import java.util.Date;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestDataProviderParallel {

	@Test(dataProvider = "getData")
	public void browserfile(String browser) throws InterruptedException {

		Date d = new Date();
		System.out.println("Browser name: " + browser + "-----" + d);
		Thread.sleep(2000);

	}

	@DataProvider(parallel = true)
	public Object[][] getData() {

		Object[][] data = new Object[2][1];

		data[0][0] = "ChromeBrowser";
		data[1][0] = "FirefoxBrowser";

		return data;

	}

}
