package com.baseClass;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.utility.Log;

public class BaseClass {

	public static WebDriver driver;
		@BeforeSuite
		
		public void beforeSuite() {

			DOMConfigurator.configure("log4j.xml");
			Log.info("This is beforeSuite method");
		}
		
		@BeforeMethod
		public void setup() {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\git\\SecondProjectRepo\\SecondProject\\lib\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.phptravels.net/login");
		}
		
		 @AfterMethod
			public void tearDown() {
			 driver.close();
		 }
		
		
        @AfterSuite
		public void afterSuite() {

		//	DOMConfigurator.configure("log4j.xml");
			Log.info("This is afterSuite method");
		}

}
