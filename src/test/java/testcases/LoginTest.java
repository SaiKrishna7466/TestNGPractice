package testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.LoginPage;
import pageObjects.HomePage;
//import utilities.ReadConfig;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

public class LoginTest extends BaseClass{
	
	Logger logger = LogManager.getLogger(LoginTest.class);
	
	@BeforeMethod(alwaysRun = true)
	public void startApplication() {
		setup();
	}
	
	@Test(groups = {"smoke", "regression", "sanity"})
	public void verifyLogin() {
		
		LoginPage lp = new LoginPage(getDriver());
		HomePage hp = new HomePage(getDriver());		
		
		logger.info("=== Starting verify LoginTest ===");
		
		String email = readConfig.getEmail();
		System.out.println(email);
		String password = readConfig.getPassword();
		System.out.println(password);
		
		logger.info("Clicking Signup/Login button");
		lp.clickSignupLogin();
		
		logger.info("Entering email: " + email);
		lp.enterEmail(email);
		
		logger.info("Entering password");
		lp.enterPassword(password);
		
		logger.info("Clicking login button");
		lp.clickLoginButton();
		
		boolean isLoggedIn = hp.isUserLoggedIn();
		
		logger.info("Is user logged in: " + isLoggedIn);
		Assert.assertTrue(isLoggedIn);
		logger.info("Login assertion PASSED");
		
		hp.clickLogout();
		logger.info("Logged out successfully");
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void closeApplication() {
		tearDown();
	}

}
