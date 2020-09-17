package com.tj.pageObjects;

import org.openqa.selenium.WebDriver;

public class BasePage {
	
	public WebDriver driver;
	
	/**
	 * 定义一个获取当前页title的字符串，常用来判断打开的页面是否正确
	 */
	public String getTiele(){
		
		return driver.getTitle().trim().toString();
	}

}
