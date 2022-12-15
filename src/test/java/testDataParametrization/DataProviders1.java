package testDataParametrization;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class DataProviders1 {

	@DataProvider(name = "dp1")
	public Object[][] dataOnlyOne(Method m) {
		Object[][] data = null;

		if (m.getName().equals("get2Data")) {
			data = new Object[2][2];
			data[0][0] = "ABDUL";
			data[0][1] = "BADI";

			data[1][0] = "AZIZA";
			data[1][1] = "ABIDA";

		} else if (m.getName().equals("get3Data")) {
			data = new Object[3][3];
			data[0][0] = "ABDUL";
			data[0][1] = "BADI";
			data[0][2] = "ZARA";

			data[1][0] = "AZIZA";
			data[1][1] = "ABIDA";
			data[1][2] = "LUKNOW";

			data[2][0] = "PUNE";
			data[2][1] = "TAJPUR";
			data[2][2] = "848130";
		}

		return data;
	}

}
