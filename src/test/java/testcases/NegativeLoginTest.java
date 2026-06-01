package testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.LoginPage;

public class NegativeLoginTest extends BaseClass {

	Logger logger = LogManager.getLogger(NegativeLoginTest.class);
	
    @BeforeMethod(alwaysRun = true)
    public void startApplication() {

        setup();
    }

    @Test(groups = {"sanity","regression"})
    public void verifyInvalidLogin() {    	
    	
    	
    	logger.info("=== Starting verifyInvalidLogin test ===");

        LoginPage lp = new LoginPage(getDriver());

        logger.info("Clicking Signup/Login button");
        lp.clickSignupLogin();

        logger.info("Entering wrong email");
        lp.enterEmail("wrongemail@gmail.com");

        logger.info("Entering wrong password");
        lp.enterPassword("wrongpassword");

        logger.info("Clicking login button");
        lp.clickLoginButton();

        boolean isErrorDisplayed = lp.isInvalidLoginMessageDisplayed();
        logger.info("Is invalid login message displayed: " + isErrorDisplayed);

        Assert.assertTrue(isErrorDisplayed);
        
//        Assert.assertFalse(isErrorDisplayed, "Forcing failure to test screenshot");
        logger.info("Negative login assertion PASSED");
    }

    @AfterMethod(alwaysRun = true)
    public void closeApplication() {
        tearDown();
    }
}