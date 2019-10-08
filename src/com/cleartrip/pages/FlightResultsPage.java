package com.cleartrip.pages;

/*  Author @Krishanu
 *  This class will store the required locators and method of the Flight results page
 */


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FlightResultsPage {

	WebDriver driver;

	public FlightResultsPage(WebDriver driver)
	{
		this.driver=driver;
	}

	@FindBy (how=How.XPATH, using = ".//*[@id='flightForm']/section[2]/div[4]/div/nav/ul/li//tbody[2]/tr[2]/td[3]/button[@class='booking']")
	List<WebElement> bookButtons;

	public void clickOnBookButton()
	{	   
		int buttonCount=0;	
		for (int i=0; i < bookButtons.size(); i++)
		{
			if (buttonCount == 3)
			{
				bookButtons.get(buttonCount).click();
				break;
			}
			buttonCount=buttonCount+1;
		}
	}
}
