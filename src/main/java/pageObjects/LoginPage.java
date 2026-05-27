package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	//constructor
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver,this);
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
	
	//Action Methods
	public void clickSignupLogin() {
		signupLoginBtn.click();
	}
	
	public void enterEmail(String email) {
		emailField.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}
	
	public void clickLoginButton() {
		loginButton.click();
	}

}
