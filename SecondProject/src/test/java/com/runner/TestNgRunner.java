package com.runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;




@CucumberOptions(


	
features = "src/test/resources/Features"
,
glue= {"com.steps"},
plugin = {"pretty","html:target/cucumber-Report","json:target/report.json"}
,
tags= "@OragHRM"
)


public class TestNgRunner extends AbstractTestNGCucumberTests {

	@BeforeClass
	@Parameters({"browser"})
	public void setup(String browser) {
		WebDriverFactory.setupDriver(browser);
		// TODO Auto-generated method stub

	}

	@AfterClass
	public void teardown() {
		WebDriverFactory.getDriver().quit();
		System.out.println("Test ended");
		// TODO Auto-generated method stub

	}
	
	
}
