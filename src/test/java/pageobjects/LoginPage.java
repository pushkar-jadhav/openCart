package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//Locators
	@FindBy(id="input-email")
	WebElement emailTxtbx;
	
	@FindBy(id="input-password")
	WebElement passwdTxtbx;
	
	@FindBy(css="button[type='submit']")
	WebElement loginBtn;
	
	public void setUsername(String emailid)
	{
		emailTxtbx.sendKeys(emailid);
	}
	
	public void setPassword(String pwd)
	{
		passwdTxtbx.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		loginBtn.click();
	}
}
