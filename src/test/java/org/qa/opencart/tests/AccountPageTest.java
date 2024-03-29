package org.qa.opencart.tests;

import org.qa.opencart.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AccountPageTest extends BaseTest{
	
	@BeforeClass
	public void accPageSetup() {
		accPage = lp.doLogin("FebBatch2024@opencart.com", "123456");
	}

	@Test
	public void accounPageTitleTest() {
		String title = accPage.getAccountPageTitle();
		Assert.assertEquals(title, "My Account");
	}

	@Test
	public void accounPageUrlTest() {
		String url = accPage.getAccountPageUrl();
		Assert.assertTrue(url.contains("account/accounts"));
	}

	@Test
	public void logoutbtnExistanceTest() {
		Assert.assertTrue(accPage.isLogoutbtnExist());
	}
	
	@Test
	public void myAccountHeaderExistanceTest() {
		Assert.assertTrue(accPage.isMyAccountHeaderExist());
	}

}
