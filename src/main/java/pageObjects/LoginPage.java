package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import abstractComponents.BasePage;

public class LoginPage extends BasePage {
	
	//constructor
	public LoginPage(WebDriver driver) {
		
		super(driver);
	}
	
	//locators
	
	@FindBy(xpath="//a[contains(text(),'Signup / Login')]")
	WebElement signupLoginBtn;
	
	@FindBy(xpath ="//input[@data-qa='login-email']")
	WebElement emailField;
	
	@FindBy(name = "password")
	WebElement passwordField;
	
	@FindBy(xpath = "//button[@data-qa='login-button']")
	WebElement loginButton;

	@FindBy(xpath = "//p[text()='Your email or password is incorrect!']")
	WebElement invalidLoginMessage;
	
	
	//Action Methods
	public void clickSignupLogin() {
		waitForElementToBeClickable(signupLoginBtn);
		signupLoginBtn.click();
	}
	
	public void enterEmail(String email) {
		emailField.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}
	
	public void clickLoginButton() {
		waitForElementToBeClickable(loginButton);
		loginButton.click();
	}
	
	public boolean isInvalidLoginMessageDisplayed() {

	    return invalidLoginMessage.isDisplayed();
	}

}
