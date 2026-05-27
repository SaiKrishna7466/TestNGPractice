package testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.LoginPage;
import utilities.ReadConfig;

public class LoginTest extends BaseClass{
	
	@BeforeMethod
	public void startApplication() {
		setup();
	}
	
	@Test
	public void verifyLogin() {
		
		LoginPage lp = new LoginPage(driver);
		
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
		System.out.println("Login test executed");
	}
	
	@AfterMethod
	public void closeApplication() {
//		tearDown();
	}

}
