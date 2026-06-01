package base;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ReadConfig;

public class BaseClass {
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	
	protected ReadConfig readConfig = new ReadConfig();
	
	//logger
	public static Logger logger = LogManager.getLogger(BaseClass.class);
	
	// getter — always use this to get driver
	public static WebDriver getDriver() {
		return tlDriver.get();
	}
	
	public void setup() {
		
		String browser = readConfig.getBrowser();
		logger.info("Browser selected: " + browser);
		
		WebDriver driver;
		
		if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            logger.error("Browser not supported: " + browser);
            throw new RuntimeException("Browser not supported: " + browser);
        }		
		
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// Set driver into ThreadLocal
        tlDriver.set(driver);

        String url = readConfig.getApplicationURL();
        getDriver().get(url);
        logger.info("Application launched: " + url);
	}
	
	public void tearDown() {
		
		logger.info("Closing browser");
        getDriver().quit();
        // Remove driver from thread after test
        tlDriver.remove();
		
	}
	
	

}
