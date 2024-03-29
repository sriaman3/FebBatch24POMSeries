package org.qa.opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.qa.opencart.exception.FrameworkException;

import io.reactivex.rxjava3.observers.BaseTestConsumer;

public class DriverFactory {
	
	WebDriver driver;
	Properties prop;
	OptionsManager optManager;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	public WebDriver init_driver(Properties prop) {
		String browerName = prop.getProperty("browser");
		optManager = new OptionsManager(prop);
		switch (browerName.toLowerCase().trim()) {
		case "chrome":
			//driver = new ChromeDriver(optionsManager.getChromeOptions());
			tlDriver.set(new ChromeDriver(OptionsManager.getChromeOptions()));
			break;
		case "edge":
			//driver = new EdgeDriver(optionsManager.getEdgeOptions());
			tlDriver.set( new EdgeDriver(OptionsManager.getEdgeOptions()));
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;

		default:
			System.out.println("please pass the right browser name...." + browerName);
			throw new FrameworkException("no browser found");
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		//driver.get(prop.getProperty("url"));
		getDriver().get(prop.getProperty("url"));

		return getDriver();
	}
	
	public static WebDriver getDriver() {
		return tlDriver.get();
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
	
	/**
	 * take screenshot
	 */
	public  String getScreenshot(String methodName) {
	
		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		
		String path = System.getProperty("user.dir") + "/screenshot/" + methodName + "_" + System.currentTimeMillis()+".png";
				
		File destination = new File(path);
		
		try {
			FileHandler.copy(srcFile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return path;
	}

	

}
