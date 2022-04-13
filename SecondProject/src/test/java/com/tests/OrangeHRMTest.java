package com.tests;

import java.sql.Driver;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.baseClass.BaseClassReport;

public class OrangeHRMTest extends BaseClassReport {
	@Test
	public void loginPageTest() {
		test = extent.createTest("loginPageTest");
		WebElement imgElement = driver.findElement(By.xpath("//*[@id=\"divLogo\"]/img"));
		Assert.assertTrue(imgElement.isDisplayed());
	}
	
	@Test
	public void loginTest() {
		test = extent.createTest("loginTest");
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "OrangeHRM2";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test
	public void sampleCase() {
		test = extent.createTest("sampleCase");
		Assert.assertTrue(false);
	}
	

}
