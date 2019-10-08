package library;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Utility {

	static WebDriver driver;
	//Code to initialize different browsers
	
	
	public static WebDriver selectBrowser(String browserName, String URL)
	{
		ReadGlobalProperties rgp = new ReadGlobalProperties();	
		
		if (browserName.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", rgp.getGeckoDriverPath());
			driver = new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", rgp.getChromeDriverPath());
			driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", rgp.getIEDriverPath());
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.get(URL);
		return driver;
	}
	
	//Code to capture screenshot
	public static void screenshotCapture(WebDriver driver, String screenshotName){ // Static method
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File ("./Screenshots/" + screenshotName + ".png"));
		} catch (WebDriverException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
    
	//Code to get current date and timestamp
	public static String getCurrentDateTime()
	{
		DateFormat df = new SimpleDateFormat("YYYY_MMM_dd HH_MM_SS");
		Date d = new Date();
        String date_time = df.format(d);
        return date_time;
	}
}