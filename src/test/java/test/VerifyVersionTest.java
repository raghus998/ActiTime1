package test;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.ExcelData;
import pages.LoginPage;

public class VerifyVersionTest  extends BaseTest
{
	@Test(priority = 3)
	public void test_verifyVersion()
	{
		
		//Excel data
		 String logintitle = ExcelData.getData(file_path, "TC01", 1, 2); 
		 String eVersion = ExcelData.getData(file_path, "TC03", 1, 0);
		 
		 
		//Craete object of POM class
		LoginPage lp = new LoginPage(driver);
		
		
		//Verify Title 
		lp.verifyPageTitle(logintitle);
		
		
		//Verify Version
		String aVersion =lp.verifyVersion();
		
		//To do the verification
		Assert.assertEquals(aVersion, eVersion);
		Reporter.log("Versions are Matching",true);
		
	}

}
