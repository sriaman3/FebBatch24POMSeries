package org.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {
	
	private WebDriver driver;
	
	private By logoutbtn = By.xpath("(//a[text()='Logout'])[2]");
	private By myAccountHeader = By.xpath("//h2[text()='My Account']");
	private By loginbtn = By.xpath("(//a[text()='Login'])[2]");

	public AccountPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String getAccountPageTitle() {
		return driver.getTitle();
	}
	
	public String getAccountPageUrl() {
		return driver.getCurrentUrl();
	}
	
	public boolean isLogoutbtnExist() {
		return driver.findElement(logoutbtn).isDisplayed();
	}
	
	public boolean isMyAccountHeaderExist() {
		return driver.findElement(myAccountHeader).isDisplayed();
	}
	
	public void clickOnLogoutBtn() {
		driver.findElement(logoutbtn).click();
	}
	
	public void clickOnLoginBtn() {
		driver.findElement(loginbtn).click();
	}


}
