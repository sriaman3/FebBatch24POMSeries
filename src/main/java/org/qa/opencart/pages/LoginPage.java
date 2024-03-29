package org.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;  
	
	private By email = By.id("input-email");
	private By password = By.id("input-password");
	private By loginbtn = By.xpath("//input[@value='Login']");
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public String getLoginPageUrl() {
		return driver.getCurrentUrl();
	}
	
	public AccountPage doLogin(String uN, String pwd) {
		driver.findElement(email).sendKeys(uN);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginbtn).click();
		return new AccountPage(driver);
	}
	
	

}
