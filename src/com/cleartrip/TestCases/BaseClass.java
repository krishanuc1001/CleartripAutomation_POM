package com.cleartrip.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import library.ReadGlobalProperties;
import library.ReadWriteExcel;
import library.Utility;

public class BaseClass {

	WebDriver driver;
	ReadGlobalProperties rgp;
	ReadWriteExcel rwExcel;
	//SearchFlightPage searchFlight;

		@BeforeMethod
		public void setup()
		{
			Reporter.log("<<==========SESSION HAS STARTED========>>", true);
			rgp = new ReadGlobalProperties();
			driver = Utility.selectBrowser("chrome", rgp.getURL());	
			rwExcel = new ReadWriteExcel(rgp.getExcelPath());			
		}

		@AfterMethod
		public void tearDown()
		{
			driver.quit();
			Reporter.log("<<==========SESSION HAS FINISHED========>>", true);
		}

		@AfterMethod
		public void takeScreenshotAtFailure(ITestResult result)
		{
			if (ITestResult.FAILURE==result.getStatus())
			{
				library.Utility.screenshotCapture(driver, ("The method" + " " + result.getName() + " " + "failed at" + " " + Utility.getCurrentDateTime()));	 	
			}
		}
	}