package testDataParametrization;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestParametrization {

	@Test(dataProvider="getData")
	public void doLogin(String uname, String pass) {
		System.out.println(uname + " and " + pass);
	}
	
	@DataProvider
	public Object[][] getData() {
		
		Object[][] data = new Object[3][2];
		data[0][0] = "trainer@abc.com";
		data[0][1] = "hh666";
		
		data[1][0] = "new@nbn.com";
		data[1][1] = "6767asy";
		
		data[2][0] = "hi@hello.com";
		data[2][1] = "gghj8989";
		
		return data;
		
	}

}
