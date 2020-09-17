package com.tj.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	public LoginPage(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(css=".user-label.username>input")
	@CacheLookup
	WebElement inputbox_userName;
	
	@FindBy(css=".user-label.password>input")
	@CacheLookup
	WebElement inputbox_password;
	
	@FindBy(css=".login-toggle")
	@CacheLookup
	WebElement signIn;
	
	@FindBy(css=".submit-login")
	@CacheLookup
	WebElement LoginBtn;
	
	
	public void setUserName(String userName) {
		inputbox_userName.sendKeys(userName);	
	}
	public void clickSignIn() {	
		signIn.click();
	}
	public void setPassword(String password) {
		inputbox_password.sendKeys(password);
		
	}
	public void clickLoginBtn() {
		LoginBtn.click();
	}
}
