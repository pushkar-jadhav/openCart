package base;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class TestBase {

	public static WebDriver driver;
	public Logger logger;
	public ResourceBundle resourceBundle;
	
	@Parameters("Browser")
	@BeforeClass(groups= {"Master","Regression","Sanity"})
	public void setUp(String browser)
	{
		logger = LogManager.getLogger(this.getClass());
		resourceBundle = ResourceBundle.getBundle("config");
		
		if(browser.equalsIgnoreCase("Chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Edge"))
		{
			driver = new EdgeDriver();
		}
		else
		{
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(resourceBundle.getString("appurl"));
	}
	
	@AfterClass(groups= {"Master","Regression","Sanity"})
	public void tearDown()
	{
		driver.quit();
	}
	
	public String captureScreenshot(String name)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		String timeStamp = sdf.format(new Date());
		
		TakesScreenshot takescreenshot = (TakesScreenshot)driver;
		File src = takescreenshot.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir")+"/screenshots/"+name+"_"+timeStamp+".png";
		try {
			FileUtils.copyFile(src, new File(dest));
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		return dest;
	}
}
