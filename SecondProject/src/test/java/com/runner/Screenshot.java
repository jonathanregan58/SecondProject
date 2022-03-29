package com.runner;

import java.util.concurrent.*;

//import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.it.Date;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {

	public static ThreadLocal<WebDriver> webdriver = new ThreadLocal<WebDriver>();
	public static void setupScreenshot(long ms) {
		
		try {
		    TakesScreenshot ts = (TakesScreenshot) webdriver;
		    File source = ts.getScreenshotAs(OutputType.FILE);
		    String dest = "C:\\Users\\user\\git\\SecondProjectRepo\\SecondProject\\src\\test\\java\\com\\runner\\Screenshots\\" + ms + ".png";
		    FileUtils.copyFile(source, new File(dest));
		    System.out.println("ScreenShot Taken");
		    
		    
		   // TakesScreenshot screen = (TakesScreenshot) webdriver;
			//File src = screen.getScreenshotAs(OutputType.FILE);
			//
			//File target = new File(dest);
			//FileUtils.copyFile(src, target);
			//return dest;
		} 
		catch (Exception e) 
		{
		    System.out.println("Exception while taking ScreenShot "+e.getMessage());
		}
		// TODO Auto-generated method stub

	}
	


}
