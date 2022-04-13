package com.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.baseClass.BaseClass;
import com.utility.Log;

public class TestClass2 extends BaseClass {

	@Test
	public static void wordPressTest() {
		Log.startTestCase("phptravelsTest");
		Log.info("Entering User Name");
		driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div[2]/div[2]/div/form/div[1]/div/input")).sendKeys("user@phptravels.com");
		Log.info("Entering Password");
		driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div[2]/div[2]/div/form/div[2]/div[1]/input")).sendKeys("demouser");
		Log.info("Click on Login Button");
		driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div[2]/div[2]/div/form/div[3]/button")).click();
		Log.info("Home Page");
		Log.info("Get Current URL");
		String urlString = driver.getCurrentUrl();
		Log.info("Validation");
		String expectedURL= "https://www.phptravels.net/account/dashboard";
		Assert.assertEquals(urlString, expectedURL);
		Log.info("URL Matches");
		Log.endTestCase("phptravelsTest");
		// TODO Auto-generated method stub

	}

}
