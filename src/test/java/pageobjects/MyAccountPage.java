package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	//Locators
	@FindBy(css="div[id='content'] h1")
	WebElement labelRegistrationSuccess;
	
	@FindBy(css="div[id='account-account'] h2:nth-child(1)")
	WebElement labelMyAccount;
	
	@FindBy(css="div[class*='list-group'] a[href*='logout']")
	WebElement lnk_logout;
	
	//Methods
	public String getMessage()
	{
		try {
			return labelRegistrationSuccess.getText();
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
		
	}
	
	public boolean isMyAccountLabelDisplayed()
	{
		try {
			return labelMyAccount.isDisplayed();
		}catch(Exception e)
		{
			return false;
		}	
	}
	
	public void clickLogout()
	{
		lnk_logout.click();
	}
}
