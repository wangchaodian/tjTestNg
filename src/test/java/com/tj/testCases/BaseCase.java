package com.tj.testCases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.tj.utils.ReadConfig;

public class BaseCase {
	
	ReadConfig rc = new ReadConfig();
	public String baseURL= rc.getServerUrl();
	public String userName= rc.getUserName();
    public String password= rc.getPassword();
	public static WebDriver driver;
	
	public static Logger logger; // adding logger
	
	@BeforeClass
	public void setup() {
		
		logger = Logger.getLogger(getClass());
		PropertyConfigurator.configure("log4j.properties");
		
		
		if("firefox".equalsIgnoreCase(rc.getBrowser().trim())) {
			System.setProperty("webdriver.gecko.driver", rc.getFirefoxPath());
			driver = new FirefoxDriver();
		}else if("chrome".equalsIgnoreCase(rc.getBrowser().trim())) {
			
			ChromeOptions option = new ChromeOptions();
			option.addArguments("headless"); //瀏覽器後台運行
			option.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});// 取消提示
			System.setProperty("webdriver.chrome.driver", rc.getChromePath());
			driver = new ChromeDriver(option);
		}else {
			logger.error("暂时没有考虑其他浏览器，例如safari，你自己添加对应代码。");
		}
		

		driver.manage().window().maximize();
		// 隐式时间等待（定位对象）
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// 页面加载时的超时等待（）
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}
    
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
