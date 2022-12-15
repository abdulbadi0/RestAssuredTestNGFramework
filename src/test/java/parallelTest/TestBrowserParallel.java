package parallelTest;

import java.util.Date;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestBrowserParallel {

	@Parameters({"browser"})
	@Test
	public void browserfile(String browser) throws InterruptedException {
		
		Date d = new Date();
		System.out.println("Browser name: "+browser + "-----"+d);
		Thread.sleep(2000);
		
	}
	
}
