package utilities;

import org.testng.annotations.DataProvider;

public class DataProviderUtils {
	
	@DataProvider(name = "loginData")
	public static Object[][] getLoginData() {
		
		ReadConfig readConfig = new ReadConfig();
		
		return new Object[][] {
            // read from testdata.properties — no hard coding
            { readConfig.getValidEmail(),   readConfig.getValidPassword(),   "valid"   },
            { readConfig.getInvalidEmail(), readConfig.getInvalidPassword(), "invalid" },
            { " ",                           " ",                              "invalid" }
        };
	}

}
