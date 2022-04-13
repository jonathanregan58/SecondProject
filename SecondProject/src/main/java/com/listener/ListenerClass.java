package com.listener;

import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

import org.testng.ITestContext;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.baseClass.BaseClassReport;
import com.baseClass.BaseClassReport1;
import com.extentManager.ExtentManager;


public class ListenerClass extends ExtentManager implements ITestListener{

  public void onTestStart(ITestResult result) {
	  test = extent.createTest(result.getName());
  }
  
  public void onTestSuccess(ITestResult result) {
	  if(result.getStatus()==ITestResult.SUCCESS) {
	  test.log(Status.PASS,"Success test case is: " + result.getName());
	  }
  }
  
  public void onTestFailure(ITestResult result) {
	  if(result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
			String pathString = BaseClassReport1.screenshot(BaseClassReport1.driver, result.getName());
			try {
				test.addScreenCaptureFromPath(pathString);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
  }
  
  public void onTestSkipped(ITestResult result) {
	  if(result.getStatus()==ITestResult.SKIP) {
		  test.log(Status.SKIP,"Skipped test case is: " + result.getName());  
	  }
	  
  }
  

}
