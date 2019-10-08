package library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadGlobalProperties {
	
	Properties pro;
	public ReadGlobalProperties()
	{
		try {
			File source = new File("E:\\Selenium\\Project\\ClearTrip\\GlobalProperties.property");
			FileInputStream fis = new FileInputStream(source);
			pro = new Properties();
			pro.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	public String getGeckoDriverPath()
	{
		String GeckoDriverPath = pro.getProperty("GeckoDriver");
		return GeckoDriverPath;	
	}
	public String getChromeDriverPath()
	{
		String ChromeDriverPath = pro.getProperty("ChromeDriver");
		return ChromeDriverPath;	
	}
	public String getIEDriverPath()
	{
		String IEDriverPath = pro.getProperty("IEDriver");
		return IEDriverPath;
	}
	public String getURL()
	{
		String URL = pro.getProperty("URL");
		return URL;
	}
	public String getExcelPath()
	{
		String excelPath = pro.getProperty("ExcelPath");
		return excelPath;
	}
}
