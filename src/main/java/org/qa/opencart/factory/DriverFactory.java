package org.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.qa.opencart.exception.FrameworkException;

public class DriverFactory {
	
	WebDriver driver;
	Properties prop;
	OptionsManager optManager;
	
	public WebDriver init_driver(Properties prop) {
		String browerName = prop.getProperty("browser");
		optManager = new OptionsManager(prop);
		switch (browerName.toLowerCase().trim()) {
		case "chrome":
			driver = new ChromeDriver(optManager.getChromeOptions());
			break;
		case "edge":
			driver = new EdgeDriver(optManager.getEdgeOptions());
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;

		default:
			System.out.println("Please pass the correct browser" + browerName + "name.");
			throw new FrameworkException("No Browser Found");
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		
		return driver;
	}
	
	public Properties init_prop() {
		
		prop = new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream("src/test/resources/config/config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
		
	}
	

}
