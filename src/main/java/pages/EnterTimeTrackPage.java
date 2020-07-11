package pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.BasePage;

public class EnterTimeTrackPage  extends BasePage
{
	// Declaring WebElement
	@FindBy(id = "logoutLink")
	private WebElement logoutLink;
	
	
	// initilization of webelement through Constrctor
		public EnterTimeTrackPage(WebDriver driver)
		{
			super(driver);
			PageFactory.initElements(driver, this);
		}
		

	// Utlization through public method
		
	public void clickOnLogOutLink()
	{
		logoutLink.sendKeys(Keys.ENTER);
	}

}
