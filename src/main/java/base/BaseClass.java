package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ReadConfig;

public class BaseClass {
	
	public static WebDriver driver;
	
	ReadConfig readConfig = new ReadConfig();
	
	public void setup() {
		
		String browser = readConfig.getBrowser();
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			
			driver = new ChromeDriver();
		}	
		
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(readConfig.getApplicationURL());
		
		try {
			Thread.sleep(5000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public void tearDown() {
		
		driver.quit();
		
	}
	
	

}
