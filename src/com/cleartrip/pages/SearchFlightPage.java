package com.cleartrip.pages;

import java.util.List;

/*  Author @Krishanu
 *  This class will store all the locators and methods of the SearchFlight page
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchFlightPage {

	WebDriver driver;

	/*
	 * Here we are creating a Constructor for the SearchFlightPage class.Constructor
	 * will have the same name as the class. We will be parameterizing this
	 * constructor with WebDriver driver. And also we need to declare this WebDriver
	 * driver Object reference variable globally. We will be calling this driver
	 * from our test cases. The main task of this Constructor is to initialize this
	 * WebDriver.
	 * 
	 */

	public SearchFlightPage(WebDriver driver) {
		this.driver = driver;
	}

	/*
	 * This is using PageFactory selenium support library. To achieve this we
	 * use @FindBy with How to identify the Web elements
	 * 
	 */

	@FindBy(xpath = ".//*[@id='Home']/div/div/ul/li/div/div[2]/aside[1]/nav/ul[1]/li[1]/a[1]")
	WebElement flights;

	@FindBy(xpath = ".//*[@id='OneWay']")
	WebElement oneWayRadioButton;

	@FindBy(how = How.XPATH, using = ".//*[@id='FromTag']")
	WebElement from;

	@FindBy(how = How.ID, using = "ToTag")
	WebElement to;

	@FindBy(how = How.XPATH, using = ".//*[@id='ORtrip']/section[2]/div[1]/dl/dd/div/a/i[@class='icon ir datePicker']")
	WebElement datePicker;

	@FindBy(how = How.XPATH, using = ".//*[@id='ui-datepicker-div']/div[@class='monthBlock first']//td")
	List<WebElement> firstMonth;

	@FindBy(how = How.XPATH, using = ".//*[@id='ui-datepicker-div']/div[@class='monthBlock last']//td")
	List<WebElement> lastMonth;

	@FindBy(how = How.XPATH, using = ".//*[@id='Adults']")
	WebElement adults;

	@FindBy(how = How.CSS, using = "#Childrens[class='span span15']")
	WebElement children;

	@FindBy(how = How.XPATH, using = ".//*[@id='SearchBtn']")
	WebElement searchFlightsButton;

	/*
	 * All the locators of the Search Flight page are specified below This approach
	 * is without using PageFactory class of Selenium
	 * 
	 */
	/*
	 * By flights = By.xpath(
	 * ".//*[@id='Home']/div/div/ul/li/div/div[2]/aside[1]/nav/ul[1]/li[1]/a[1]");
	 * By oneWayRadioButton = By.xpath(".//*[@id='OneWay']"); By from =
	 * By.xpath(".//*[@id='FromTag']"); By to = By.xpath(".//*[@id='ToTag']"); By
	 * departOn = By.xpath(".//*[@id='ORtrip']/section[2]/div[1]/dl/dd/div/a/i"); By
	 * datePicker =
	 * By.xpath(".//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr[4]/td[2]/a");
	 * By adults = By.xpath(".//*[@id='Adults']"); By children =
	 * By.cssSelector("#Childrens[class='span span15']"); By searchFlightsButton =
	 * By.xpath(".//*[@id='SearchBtn']");
	 */

	/*
	 * Now we have to create the methods to perform actions on this page using the
	 * locators above. This approach is without using PageFactory class of Selenium
	 * 
	 */
	public void searchFlightOnCleartrip(String origin, String dest) // Created a Non-static method. Means we have to
																	// create an object to use this method
	{
		/*
		 * This approach is without using PageFactory class of Selenium
		 */
		/*
		 * driver.findElement(flights).click();
		 * driver.findElement(oneWayRadioButton).click();
		 * driver.findElement(from).sendKeys(origin);
		 * driver.findElement(to).sendKeys(dest); driver.findElement(departOn).click();
		 * driver.findElement(datePicker).click();
		 * 
		 * WebElement adtDD = driver.findElement(adults); Select adult = new
		 * Select(adtDD); adult.selectByVisibleText("2");
		 * 
		 * WebElement chdDD = driver.findElement(children); Select children = new
		 * Select(chdDD); children.selectByValue("1");
		 * 
		 * driver.findElement(searchFlightsButton).click();
		 * 
		 */
		// This approach is using Page Factory model
		flights.click();
		oneWayRadioButton.click();
		from.sendKeys(origin);
		to.sendKeys(dest);
		datePicker.click();

		for (int i = 0; i < firstMonth.size(); i++) {
			WebElement firstMonthDates = firstMonth.get(i);
			String firstMonthDatesVal = firstMonthDates.getText();
			if (firstMonthDatesVal.equals("31")) {
				firstMonthDates.click();
				break;
			}
		}

		/*
		 * for (int i=1; i< lastMonth.size(); i++) { WebElement lastMonthDates =
		 * lastMonth.get(i); //String firstMonthDatesVal =
		 * firstMonthDates.getAttribute("innerHTML"); if
		 * (lastMonthDates.getAttribute("innerHTML").equalsIgnoreCase("10")) {
		 * lastMonthDates.click(); break; } }
		 */

		WebElement adtDD = adults;
		Select adult = new Select(adtDD);
		adult.selectByVisibleText("2");

		WebElement chdDD = children;
		Select children = new Select(chdDD);
		children.selectByValue("1");

		searchFlightsButton.click();

		// Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(".//*[@id='flightForm']/section[2]/div[4]/div/nav/ul/li[3]/table/tbody[2]/tr[2]/td[3]/button")));
	}
}
