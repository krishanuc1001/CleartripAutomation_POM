package com.cleartrip.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.cleartrip.pages.FlightBookingPage;
import com.cleartrip.pages.FlightResultsPage;
import com.cleartrip.pages.SearchFlightPage;

public class FlightBooking extends BaseClass{

	//WebDriver driver;
	//ReadGlobalProperties rgp;
	//ReadWriteExcel rwExcel;
	SearchFlightPage searchFlight;
	FlightResultsPage frp;
    FlightBookingPage fbp;
	
	/*  @BeforeTest
	public void setup()
	{
		rgp = new ReadGlobalProperties();
		driver = Utility.selectBrowser("Chrome", rgp.getURL());
		rwExcel = new ReadWriteExcel(rgp.getExcelPath());
		System.out.println("<<=======SETUP IS COMPLETE========>>");
	} */
	@Test(description="This test books a flight")
	public void FlightBookingMethod() throws Exception
	{	
		/*ReadGlobalProperties rgp = new ReadGlobalProperties();
		WebDriver driver = Utility.selectBrowser("Chrome", rgp.getChromeDriverPath());
		ReadWriteExcel rwExcel = new ReadWriteExcel(rgp.getExcelPath()); */

		Reporter.log("<<==========TEST HAS STARTED========>>", true);

		searchFlight = PageFactory.initElements(driver, SearchFlightPage.class);
		searchFlight.searchFlightOnCleartrip(rwExcel.getExcelData(0, 1, 0), rwExcel.getExcelData(0, 1, 1));	

		frp = PageFactory.initElements(driver,FlightResultsPage.class);
		frp.clickOnBookButton();
		
		fbp = PageFactory.initElements(driver, FlightBookingPage.class);
		fbp.segmentConfirmation();

		Reporter.log("<<==========TEST HAS FINISHED========>>", true);
	}

	/*  @AfterMethod
	public void takeScreenshotAtFailure(ITestResult result)
	{
		if (ITestResult.FAILURE==result.getStatus())
		{
			library.Utility.screenshotCapture(driver, result.getName());	 	
		}
	} */
}
