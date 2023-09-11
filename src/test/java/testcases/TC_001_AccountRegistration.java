package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import pageobjects.HomePage;
import pageobjects.MyAccountPage;
import pageobjects.RegisterUserPage;
import utilities.RandomData;

public class TC_001_AccountRegistration extends TestBase{

	
	
	@Test(groups= {"Regression","Master"})
	public void testAccountRegistration()  
	{
		logger.info("*******Starting testAccountRegistration*******");
		try {
			HomePage homepage = new HomePage(driver);
			homepage.clickMyAccount();
			homepage.clickRegister();
			logger.info("Entering registration details");
			RegisterUserPage register = new RegisterUserPage(driver);
			register.setFirstName(RandomData.randomString(5));
			
			register.setLastName(RandomData.randomString(5));
			
			register.setEmail(RandomData.randomAlphaNumeric(5)+"@example.com");
			
			register.setPassword("Test@123");
			
			register.clickAgree();
			logger.info("Click on Continue");
			register.clickContinue();
			Thread.sleep(3000);
			MyAccountPage account = new MyAccountPage(driver);
			String message = account.getMessage();
			logger.info("Validating success message");
			Assert.assertEquals(message, "Your Account Has Been Created!");	
		}catch(Exception e)
		{
			logger.error("Test failed"+e.getStackTrace());
			Assert.fail();
		}
			
		logger.info("*******Finished testAccountRegistration*******");
		
	}
}
