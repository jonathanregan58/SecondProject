package com.extentManager;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.baseClass.BaseClassReport1;

public class ExtentManager {

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static WebDriver driver;
	
	
	public static void setExtent() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+ "/test-output/ExtentReport/" + "MyReport_"+BaseClassReport1.getCurrentTime()+".html");
		htmlReporter.config().setDocumentTitle("Automation Test Report");
		htmlReporter.config().setReportName("OrangeHRM Test Automation Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("ProjectName", "OrangeHRM");
		extent.setSystemInfo("Tester", "Regan");
		extent.setSystemInfo("OS", "Win10");
		
	}
	
	public static void endReport() {
		extent.flush();
	}

}
