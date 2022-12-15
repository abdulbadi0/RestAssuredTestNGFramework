package testDataParametrization;

import org.testng.annotations.Test;

public class NewLoginTest {

	@Test(dataProviderClass = DataProviders1.class , dataProvider="dp1")
	public void get2Data(String uname, String upass) {
		System.out.println(uname + " and " + upass);
	}

	@Test(dataProviderClass = DataProviders1.class , dataProvider="dp1")
	public void get3Data(String uname, String upass, String correct) {
		System.out.println(uname + " and " + upass + " and "+correct);
	}
}
