package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	//Locators
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement dd_myAccount;
	
	@FindBy(css="a[href*='register']")
	WebElement lnk_register;
	
	@FindBy(css="a[href*='login']")
	WebElement lnk_login;
	
	//Methods

	public void clickMyAccount()
	{
		dd_myAccount.click();
	}
	
	public void clickRegister()
	{
		lnk_register.click();
	}
	
	public void clickLogin()
	{
		lnk_login.click();
	}
}
