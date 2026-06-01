package testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;

public class LaunchTest extends BaseClass {
	
	Logger logger = LogManager.getLogger(LaunchTest.class);
	
	@BeforeMethod(alwaysRun = true)
	public void startApplication() {
		setup();
	}
	
	@Test(groups= { "smoke"})
	public void verifyApplicationLaunch() {
		
		logger.info("=== Starting LaunchTest ===");
		
		logger.info("Getting the page title");
		System.out.println(getDriver().getTitle());
	}
	
	@AfterMethod(alwaysRun = true)
	public void closeApplication() {
		tearDown();
	}

}
