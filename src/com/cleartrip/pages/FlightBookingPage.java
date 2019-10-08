package com.cleartrip.pages;

import org.openqa.selenium.WebDriver;

import library.Utility;

public class FlightBookingPage {

	WebDriver driver;
	
	public FlightBookingPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void segmentConfirmation()
	{
		Utility.screenshotCapture(driver, ("Screenshot of the selected Segment" + " " + Utility.getCurrentDateTime()));		
	}
	
}
