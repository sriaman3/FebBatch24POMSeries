package org.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.qa.opencart.factory.DriverFactory;
import org.qa.opencart.pages.AccountPage;
import org.qa.opencart.pages.LoginPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {
	
	protected WebDriver driver;
	protected DriverFactory df;
	protected LoginPage lp;
	protected AccountPage accPage;
	protected Properties prop;
	
	@Parameters({"browser"})
	@BeforeTest
	public void setup(String browserName) {
		
		df = new DriverFactory();
		prop = df.init_prop();
		if(browserName!=null) {
			prop.setProperty("browser", browserName);
		}
		driver = df.init_driver(prop);
		lp = new LoginPage(driver);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
