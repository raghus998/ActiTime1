package generic;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public  abstract class BaseTest implements Autoconstanst
{
	public WebDriver driver;
	
	static
	{
		System.setProperty(chrome_Key, chrome_value);
		System.setProperty(firefox_key, firefox_value);
	}
	
	@BeforeMethod
	public void precondition()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.actitime.com/login.do");
	}
	
	
	@AfterMethod
	public void postcondition(ITestResult res)
	{
		int status = res.getStatus();
		if (status == 2)
		{
			String name = res.getName();
			GenericUtils.takeScreenshot(driver, name);
		}
		driver.close();
	}

}
