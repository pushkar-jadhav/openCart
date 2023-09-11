package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;

public class TC_002_LoginTest extends TestBase{

	@Test(groups= {"Master","Sanity"})
	public void validateUserLogin()
	{
		try {
		logger.info("********Starting validateUserLogin********");
		HomePage homepage = new HomePage(driver);
		homepage.clickMyAccount();
		homepage.clickLogin();
		logger.info("Clicked pn login link");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.setUsername(resourceBundle.getString("username"));
		loginpage.setPassword(resourceBundle.getString("password"));
		logger.info("Entered username and password");
		loginpage.clickLogin();
		logger.info("Clicked on login button");
		MyAccountPage myaccount = new MyAccountPage(driver);
		Assert.assertTrue(myaccount.isMyAccountLabelDisplayed(),"My Account label not displayed, login failed!!");
		}
		catch(Exception e)
		{
			Assert.fail(e.getMessage());
		}
		logger.info("********Finished validateUserLogin********");
	}
}
