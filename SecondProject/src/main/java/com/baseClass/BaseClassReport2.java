package com.baseClass;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.extentManager.ExtentManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
//import java.sql.Date;
import java.text.SimpleDateFormat;
//import java.i
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClassReport2 {
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	public static WebDriver driver;
	public Properties prop;
	
	@BeforeSuite
	public void beforeSuite() {
		ExtentManager.setExtent();
		
	}
	@AfterSuite
	public void afterSuite() {
		ExtentManager.endReport();
	}
	
	@BeforeMethod
	public void setup() {
		readConfig();
		System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\git\\SecondProjectRepo\\SecondProject\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
	}
	
		@AfterMethod
		public void tearDown() throws IOException{
			/*if(result.getStatus()==ITestResult.FAILURE) {
				test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
				test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
				String pathString = BaseClassReport.screenshot(driver, result.getName());
				test.addScreenCaptureFromPath(pathString);
			}
			else if(result.getStatus()==ITestResult.SKIP) {
				test.log(Status.SKIP,"Skipped test case is: " + result.getName());
			}
			else if(result.getStatus()==ITestResult.SUCCESS) {
				test.log(Status.PASS,"Success test case is: " + result.getName());
			}*/
			
		 driver.close();
	 }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static String screenshot(WebDriver driver, String filename) {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source  = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+"\\Screenshot\\"+filename+"_"+dateName+".png";
		File finalDestination = new File(destination);
		
		try
		{
			FileUtils.copyFile(source, finalDestination);
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		return destination;
	}
	
	public static String getCurrentTime(){
		  String currentDate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
		  return currentDate;
		}

	public void readConfig(){
		
		try {
			prop = new Properties();
			FileInputStream fs;
			fs = new FileInputStream(System.getProperty("user.dir")+"/\\Configuration\\config.properties");
			prop.load(fs);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
