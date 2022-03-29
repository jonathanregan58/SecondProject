package com.runner;

import java.util.concurrent.*;

//import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;



public class WebDriverFactory {
	
	public static ThreadLocal<WebDriver> webdriver = new ThreadLocal<WebDriver>();

	public static void setupDriver(String browser) {
		WebDriver driver = null;
		if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browser.equals("chrome"))
		{
		

			
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
			
			
		//	 System.out.println("Inside Step - user is on process(This uses POM)");
				
				//System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
				//driver = (WebDriver) new ChromeDriver();
				
				
				
				//driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
				//driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
				//Thread.sleep(4000);
				
				//driver.navigate().to("http://tutorialsninja.com/demo/index.php");
			
		}
		
		webdriver.set(driver);
		webdriver.get().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
	
	public static WebDriver getDriver() {
		return webdriver.get();
		
		

	}

}
