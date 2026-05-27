package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	Properties properties;
	
	public ReadConfig() {
		
		try {
			
			File config = new File("/src/main/resources/config.properties");
			
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + config);
			
			properties = new Properties();
			
			properties.load(fis);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public String getApplicationURL() {
		
		return properties.getProperty("url");
	}
	
	public String getBrowser() {
		
		return properties.getProperty("browser");
	}
	
	public String getEmail() {
		return properties.getProperty("email");
	}
	
	public String getPassword() {
		return properties.getProperty("password");
	}

}
