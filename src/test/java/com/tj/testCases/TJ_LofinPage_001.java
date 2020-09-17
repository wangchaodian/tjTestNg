package com.tj.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tj.pageObjects.LoginPage;


public class TJ_LofinPage_001 extends BaseCase {

	@Test
	public void TestLogin() throws InterruptedException {
		driver.get(baseURL);
		logger.info("url opened.");
		Thread.sleep(2000);
		LoginPage lp = new LoginPage(driver);
		lp.clickSignIn();
		Thread.sleep(1000);
		lp.setUserName(userName);
		lp.setPassword(password);
		lp.clickLoginBtn();
		
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		
		if("1".equalsIgnoreCase(driver.getTitle())) {
			Assert.assertTrue(true);
		}else {
			Assert.assertFalse(false);
		}
		
	}
}
