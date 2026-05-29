package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.LoginPage;

public class NegativeLoginTest extends BaseClass {

    @BeforeMethod
    public void startApplication() {

        setup();
    }

    @Test
    public void verifyInvalidLogin() {

        LoginPage lp = new LoginPage(driver);

        lp.clickSignupLogin();

        lp.enterEmail("wrongemail@gmail.com");

        lp.enterPassword("wrongpassword");

        lp.clickLoginButton();

        Assert.assertTrue(lp.isInvalidLoginMessageDisplayed());

        System.out.println("Invalid login validation successful");
    }

    @AfterMethod
    public void closeApplication() {

        tearDown();
    }
}