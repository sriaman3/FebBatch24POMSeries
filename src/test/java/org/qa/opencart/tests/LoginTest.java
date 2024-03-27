package org.qa.opencart.tests;

import org.qa.opencart.base.BaseTest;
import org.qa.opencart.constants.AppConstants;
import org.qa.opencart.utils.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
	
	@DataProvider
	public Object[][] getLoginData() {
		
		return new Object[][] {
			{"FebBatch2024@opencart.com", "123456"},
			{"FebBatch2024@opencart.com", "123456"}
		};
		
	}
	
	/**
	 * With Excel Data sheet
	 * @return 
	 * @return
	 */
	@DataProvider
	public Object[][] getLoginTestExcelData() {
		return ExcelUtil.getExcelData(AppConstants.LOGIN_DATA_SHEET_NAME);
		
	}
	
	
	

	@Test(priority=0)
	public void loginPageTitleTest() {
		String title = lp.getLoginPageTitle();
		Assert.assertEquals(title, AppConstants.LOGIN_PAGE_TITLE);
	}

	@Test(priority=1)
	public void loginPageUrlTest() {
		String url = lp.getLoginPageUrl();
		Assert.assertTrue(url.contains(AppConstants.LOGIN_PAGE_URL_FRACTION));
	}

	@Test(priority=2, enabled = false)
	public void loginTest() {
		accPage = lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(accPage.getAccountPageTitle(),AppConstants.ACC_PAGE_TITLE);
	}
	
	@Test(priority = 2, dataProvider = "getLoginData",  enabled = false)
	public void getloginTest(String uN, String pwd) throws InterruptedException {
		accPage = lp.doLogin(uN, pwd);
		Thread.sleep(2000);
		accPage.clickOnLogoutBtn();
		Thread.sleep(2000);
		accPage.clickOnLoginBtn();
		//Assert.assertEquals(accPage.getAccountPageTitle(),AppConstants.ACC_PAGE_TITLE);
	}
	
	@Test(priority = 2, dataProvider = "getLoginTestExcelData")
	public void getloginTestExcelData(String uN, String pwd) throws InterruptedException {
		accPage = lp.doLogin(uN, pwd);
		Thread.sleep(2000);
		accPage.clickOnLogoutBtn();
		Thread.sleep(2000);
		accPage.clickOnLoginBtn();
		//Assert.assertEquals(accPage.getAccountPageTitle(),AppConstants.ACC_PAGE_TITLE);
	}


}
