package testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;

public class LaunchTest extends BaseClass {
	
	@BeforeMethod
	public void startApplication() {
		setup();
	}
	
	@Test
	public void verifyApplicationLaunch() {
		System.out.println(driver.getTitle());
	}
	
	@AfterMethod
	public void closeApplication() {
		tearDown();
	}

}
