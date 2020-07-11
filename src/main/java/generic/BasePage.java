package generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class BasePage 
{
	WebDriver driver; 
	
	public BasePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	
	public void verifyTitle(String eTitle)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try
		{
			wait.until(ExpectedConditions.titleIs(eTitle));
			Reporter.log("Title is matching...."+driver.getTitle(),true);
		} 
		catch (Exception e)
		{
			Reporter.log("Tittle is not matching : Expected tittle is :"+eTitle,true);
			Reporter.log("Actual tittle is :"+driver.getTitle(),true);
			Assert.fail();
		}
	}

	
	
	public void verifyWebElement(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try
		{
			wait.until(ExpectedConditions.visibilityOf(element));
			Reporter.log("Element is displaying",true);
		} 
		catch (Exception e) 
		{
			Reporter.log("Element is not displaying",true);
			Assert.fail();

		}
	}
	
}
//Exp title is : 123
//Actual title is " 321" in case u have fail TC