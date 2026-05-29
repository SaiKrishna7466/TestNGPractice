package testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.LoginPage;
import pageObjects.HomePage;
import utilities.ReadConfig;

import org.testng.Assert;



public class LoginTest extends BaseClass{
	
	@BeforeMethod
	public void startApplication() {
		setup();
	}
	
	@Test
	public void verifyLogin() {
		
		LoginPage lp = new LoginPage(driver);
		HomePage hp = new HomePage(driver);
		
		ReadConfig readConfig = new ReadConfig();
		
		System.out.println("Entered");
		
		String email = readConfig.getEmail();
		System.out.println(email);
		String password = readConfig.getPassword();
		System.out.println(password);
		
		lp.clickSignupLogin();
		lp.enterEmail(email);
		lp.enterPassword(password);
		lp.clickLoginButton();
		
		Assert.assertTrue(hp.isUserLoggedIn());
		System.out.println("Login successful");
		
		hp.clickLogout();
		
	}
	
	@AfterMethod
	public void closeApplication() {
//		tearDown();
	}

}
