package parallelTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestInvocation {

	@Test(invocationCount = 5)
	public void executeTest() {
		System.out.println("Launching chrome browser");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://twitter.com/i/flow/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.quit();

	}

}
