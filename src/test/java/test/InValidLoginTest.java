package test;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.ExcelData;
import pages.LoginPage;

public class InValidLoginTest extends BaseTest
{

	@Test(priority = 2)
	public void test_InvalidLogin() throws InterruptedException
	{

		//Excel data
		 String logintitle = ExcelData.getData(file_path, "TC01", 1, 2); 
		 String eErrorMsg = ExcelData.getData(file_path, "TC02", 1, 2);
		int rc = ExcelData.getLastRowNumber(file_path, "TC02");
		
		for (int i = 0; i < rc; i++) 
		{
			String un = ExcelData.getData(file_path, "TC02",i,0);
			String pw  = ExcelData.getData(file_path, "TC02",i,1);
			
			//Create the POM class Object
			LoginPage lp = new LoginPage(driver);
			
			
			//Verify Title 
			lp.verifyPageTitle(logintitle);
			
			//Enter invalid username
			lp.enterUserName(un);
			Reporter.log("INValid UN : "+un,true);
			
			
			//Enter invalid password
			lp.enterPassword(pw);
			Reporter.log("InValid PW : "+pw,true);
			
			
			//click on Login
			lp.clickOnLoginBtn();
			
			//Verify Error message
			String aErrorMsg = lp.verifyErrorMsg();
			
			//To do the verification
			Assert.assertEquals(aErrorMsg, eErrorMsg);
			Reporter.log("Both the Message are matching",true);
			Thread.sleep(1000);
			
		}
		 
	}
}
