package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import abstractComponents.BasePage;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//a[contains(text(),'Logged in as')]")
    WebElement loggedInUserText;

    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    WebElement logoutButton;
    
    // Validation Method

    public boolean isUserLoggedIn() {

        return loggedInUserText.isDisplayed();
    }

    // Logout Action

    public void clickLogout() {

        waitForElementToBeClickable(logoutButton);

        logoutButton.click();
    }
	
	
}
