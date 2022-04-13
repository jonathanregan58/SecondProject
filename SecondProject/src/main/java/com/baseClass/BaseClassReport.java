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

import java.io.File;
import java.io.IOException;
//import java.sql.Date;
import java.text.SimpleDateFormat;
//import java.i
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClassReport {
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	public static WebDriver driver;
	
	@BeforeSuite
	public void setExtent() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+ "/test-output/ExtentReport/MyReport.html");
		htmlReporter.config().setDocumentTitle("Automation Test Report");
		htmlReporter.config().setReportName("OrangeHRM Test Automation Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("ProjectName", "OrangeHRM");
		extent.setSystemInfo("Tester", "Regan");
		extent.setSystemInfo("OS", "Win10");
		
	}
	@AfterSuite
	public void endReport() {
		extent.flush();
	}
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\git\\SecondProjectRepo\\SecondProject\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials");
	}
	
		@AfterMethod
		public void tearDown(ITestResult result) throws IOException{
			if(result.getStatus()==ITestResult.FAILURE) {
				test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
				test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
				String pathString = BaseClassReport.screenshot(driver, result.getName());
				test.addScreenCaptureFromPath(pathString);
			}
			else if(result.getStatus()==ITestResult.SKIP) {
				test.log(Status.SKIP,"Skipped test case is: " + result.getName());
			}
			else if(result.getStatus()==ITestResult.SUCCESS) {
				test.log(Status.PASS,"Skipped test case is: " + result.getName());
			}
			
		 driver.close();
	 }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static String screenshot(WebDriver driver, String filename) {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source  = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+"\\Screenshot\\"+filename+" .png";
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

}
