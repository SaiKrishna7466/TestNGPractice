package testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utilities.DataProviderUtils;

public class DataDrivenLoginTest extends BaseClass {

    public static Logger logger = LogManager.getLogger(DataDrivenLoginTest.class);

    @BeforeMethod(alwaysRun = true)
    public void startApplication() {
        setup();
    }

    @Test(dataProvider = "loginData", dataProviderClass = DataProviderUtils.class)
    public void verifyLoginWithMultipleData(String email, String password, String expected) {

        logger.info("=== DataDriven Login Test ===");
        logger.info("Email: " + email + " | Expected: " + expected);

        LoginPage lp = new LoginPage(getDriver());
        HomePage hp = new HomePage(getDriver());

        lp.clickSignupLogin();
        lp.enterEmail(email);
        lp.enterPassword(password);
        lp.clickLoginButton();

        if (expected.equals("valid")) {
            Assert.assertTrue(hp.isUserLoggedIn());
            logger.info("Valid login assertion PASSED");
            hp.clickLogout();
        } else {
            Assert.assertTrue(lp.isInvalidLoginMessageDisplayed());
            logger.info("Invalid login assertion PASSED");
        }
    }

    @AfterMethod(alwaysRun = true)
    public void closeApplication() {
        tearDown();
    }
}