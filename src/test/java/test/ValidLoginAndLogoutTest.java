package test;

import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.ExcelData;
import pages.EnterTimeTrackPage;
import pages.LoginPage;

public class ValidLoginAndLogoutTest extends BaseTest
{

	@Test(priority = 1)
	public void test_ValidLoginLogOut()
	{
		
		//Excel data
		 String logintitle = ExcelData.getData(file_path, "TC01", 1, 2); 
	     String un = ExcelData.getData(file_path, "TC01", 1, 0);
	     String pw = ExcelData.getData(file_path, "TC01", 1, 1);
	     String entertitle = ExcelData.getData(file_path, "TC01", 1, 3); 
		 
		 
		//Craete object of POM class
		LoginPage lp = new LoginPage(driver);
		EnterTimeTrackPage ep = new EnterTimeTrackPage(driver);
		
		
		//Verify Title
		lp.verifyPageTitle(logintitle);
		
		
		//Enter Valid UN
		lp.enterUserName(un);
		Reporter.log("Valid UN : "+un,true);
		
		//Enter PW
		lp.enterPassword(pw);
		Reporter.log("Valid PW : "+pw,true);
		
		//Click on Login Btn
		lp.clickOnLoginBtn();
		
		//Verify Enter Title
		lp.verifyPageTitle(entertitle);
		
		//Click on Logout Btn
		ep.clickOnLogOutLink();
		
		//Verify Title
		lp.verifyPageTitle(logintitle);

		
	}
}
