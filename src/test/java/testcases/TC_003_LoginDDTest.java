package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;
import utilities.DataProviders;

public class TC_003_LoginDDTest extends TestBase {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void validateDDUserLogin(String username, String password, String status) {
		try {
			logger.info("********Starting validateDDUserLogin********");
			HomePage homepage = new HomePage(driver);
			homepage.clickMyAccount();
			homepage.clickLogin();
			logger.info("Clicked on login link");

			LoginPage loginpage = new LoginPage(driver);
			loginpage.setUsername(username);
			loginpage.setPassword(password);
			logger.info("Entered username and password");

			loginpage.clickLogin();
			logger.info("Clicked on login button");

			MyAccountPage myaccount = new MyAccountPage(driver);
			boolean actual = myaccount.isMyAccountLabelDisplayed();
			if (status.equalsIgnoreCase("valid")) {
				if (actual) {
					myaccount.clickLogout();
					Assert.assertTrue(actual);
				} else
					Assert.assertTrue(actual);
			}

			if (status.equalsIgnoreCase("invalid")) {
				if (actual) {
					myaccount.clickLogout();
					Assert.assertFalse(actual);
				} else
					Assert.assertFalse(actual);
			}
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		logger.info("********Finished validateDDUserLogin********");
	}
}
