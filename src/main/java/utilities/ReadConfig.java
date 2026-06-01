package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	private Properties configProp    = new Properties();
    private Properties testDataProp  = new Properties();
	
	public ReadConfig() {
		
		try {
			
			//Load config.properties
			
			File config = new File("/src/main/resources/config.properties");
			
			FileInputStream configFile = new FileInputStream(System.getProperty("user.dir") + config);
			configProp.load(configFile);
			
			//Load testdata.properties
			
			File testdata = new File("/src/test/resources/testdata.properties");
			
			FileInputStream testDataFile = new FileInputStream(System.getProperty("user.dir") + testdata);
			testDataProp.load(testDataFile);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	// config.properties getters
    public String getApplicationURL() {
        return configProp.getProperty("url");
    }

    public String getBrowser() {
        return configProp.getProperty("browser");
    }

    public String getEmail() {
        return configProp.getProperty("email");
    }

    public String getPassword() {
        return configProp.getProperty("password");
    }
    
 // testdata.properties getters
    public String getValidEmail() {
        return testDataProp.getProperty("validEmail");
    }

    public String getValidPassword() {
        return testDataProp.getProperty("validPassword");
    }

    public String getInvalidEmail() {
        return testDataProp.getProperty("invalidEmail");
    }

    public String getInvalidPassword() {
        return testDataProp.getProperty("invalidPassword");
    }
	
}
