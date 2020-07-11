package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.BasePage;

public class LoginPage extends BasePage
{
	// Declaring WebElement
	@FindBy(id = "username")
	private WebElement userName;
	
	@FindBy(name = "pwd")
	private WebElement password;
	
	@FindBy(id = "loginButton")
	private WebElement loginBtn;
	
	@FindBy(xpath = "//span[.='Username or Password is invalid. Please try again.']")
	private WebElement errorMsg;
	
	@FindBy(xpath = "//nobr[.='actiTIME 2020 Online']")
	private WebElement version;
	
	
	
	
	
	// initilization of webelement through Constrctor
	public LoginPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	
	

	// Utlization through public method
	public void verifyPageTitle(String title)
	{
		verifyTitle(title);
	}
	
	
	public void enterUserName(String un)
	{
		userName.sendKeys(un);
	}
	
	
	public void enterPassword(String pw)
	{
		password.sendKeys(pw);
	}
	
	
	public void clickOnLoginBtn()
	{
		loginBtn.click();
	}
	
	
	public String verifyErrorMsg()
	{
		verifyWebElement(errorMsg);
		String aErrorMsg = errorMsg.getText();
		return aErrorMsg;
	}
	
	
	
	public String verifyVersion()
	{
		verifyWebElement(version);
		String aVersion = version.getText();
		return aVersion;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
