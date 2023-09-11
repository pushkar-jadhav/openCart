package pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class RegisterUserPage extends BasePage{

	JavascriptExecutor js = (JavascriptExecutor)driver;
	public RegisterUserPage(WebDriver driver) {
		super(driver);
	}

	//Locators
	@FindBy(id="input-firstname")
	WebElement txtFirstName;
	
	@FindBy(id="input-lastname")
	WebElement txtLastName;

	@FindBy(id="input-email")
	WebElement txtEmail;
	
	@FindBy(id="input-password")
	WebElement txtPassword;
	
	@FindBy(css="button[type='submit']")
	WebElement btnSubmit;
	
	@FindBy(name="agree")
	WebElement chkbxAgree;
	
	@FindBy(css="footer div[class='container']")
	WebElement footer;
	//Methods
	
	public void setFirstName(String fname)
	{
		txtFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		txtLastName.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void clickAgree()
	{
		
		js.executeScript("arguments[0].click();",chkbxAgree);
		//chkbxAgree.click();
	}
	
	public void clickContinue()
	{
		js.executeScript("arguments[0].click();",btnSubmit);
		//btnSubmit.click();
	}
}
