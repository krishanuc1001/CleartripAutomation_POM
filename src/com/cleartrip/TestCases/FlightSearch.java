package com.cleartrip.TestCases;

import org.testng.annotations.Test;
import org.testng.Reporter;
import org.openqa.selenium.support.PageFactory;
import com.cleartrip.pages.SearchFlightPage;

/**
 * @author Krishanu
 * This test case will search for the required flight and provide the search results based on the search parameters.  
 *
 */

public class FlightSearch extends BaseClass {

	//WebDriver driver;
	//ReadGlobalProperties rgp;
	//ReadWriteExcel rwExcel;
	SearchFlightPage searchFlight;

	/*  @BeforeMethod
	public void setup()
	{
		rgp = new ReadGlobalProperties();
		driver = Utility.selectBrowser("chrome", rgp.getURL());	
		rwExcel = new ReadWriteExcel(rgp.getExcelPath());
		System.out.println("<<=======SETUP IS COMPLETE========>>");
	} */

	@Test(description="This test searches for a flight")
	public void FlightSearchMethod() throws Exception
	{		
		/*ReadGlobalProperties rgp = new ReadGlobalProperties();
		WebDriver driver = Utility.selectBrowser("chrome", rgp.getURL());	
		ReadWriteExcel rwExcel = new ReadWriteExcel(rgp.getExcelPath()); */ 

		Reporter.log("<<==========TEST HAS STARTED========>>", true);
		searchFlight = PageFactory.initElements(driver, SearchFlightPage.class);
		searchFlight.searchFlightOnCleartrip(rwExcel.getExcelData(0, 2, 0), rwExcel.getExcelData(0, 2, 1));
		Reporter.log("<<==========TEST HAS FINISHED========>>", true);

	}

	/*  @AfterMethod
	public void tearDown()
	{
		driver.quit();
		//System.out.println("<<=======TEST HAS FINISHED========>>");
		Reporter.log("<<=======Session is closed=======>>", true);
	}

	@AfterMethod
	public void takeScreenshotAtFailure(ITestResult result)
	{
		if (ITestResult.FAILURE==result.getStatus())
		{
			library.Utility.screenshotCapture(driver, result.getName());	 	
		}
	}  */
}
