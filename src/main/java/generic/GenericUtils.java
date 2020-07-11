package generic;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GenericUtils
{
	public static void takeScreenshot(WebDriver driver,String name)
	{
		try 
		{
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File dest = new File("./Screenshots/"+name+".png");
			FileUtils.copyFile(src, dest);
		} 
		catch (Exception e)
		{
			
		}
	}
	
	//we can have genaric methods to handle select,Actions class methods and popups,frames
	
	public static void selectByIndex(WebElement element,int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	public static void selectbyVisibleText(WebElement element,String text)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	
	
	public static void deSelectAll(WebElement element)
	{
		Select sel = new Select(element);
		sel.deselectAll();
	}
	
	
	
	 public static void moveToElement(WebDriver driver,WebElement element)
	 {
		 Actions act = new Actions(driver);
		 act.moveToElement(element).perform();
	 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
