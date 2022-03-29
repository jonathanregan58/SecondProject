package com.steps;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.runner.TestNgRunner;
import com.runner.WebDriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class StepsDefinitation extends TestNgRunner {

	//public static void main(String[] args) {
		// TODO Auto-generated method stub

	//}
	
	@Given("I am on Login Page")
	public void i_am_on_login_page() {
	    // Write code here that turns the phrase above into concrete actions
	    WebDriverFactory.getDriver().navigate().to("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
	}

	

	@When("I enter user name and password into input field")
	public void i_enter_user_name_and_password_into_input_field() {
		WebDriverFactory.getDriver().findElement(By.id("txtUsername")).sendKeys("Admin");
		WebDriverFactory.getDriver().findElement(By.id("txtPassword")).sendKeys("admin123");
	}

	

	@When("I click on login button")
	public void i_click_on_login_button() {
		WebDriverFactory.getDriver().findElement(By.id("btnLogin")).click();
	  
	}

	

	@Then("I verify user login succesfully")
	public void i_verify_user_login_succesfully() {
		String message = WebDriverFactory.getDriver().findElement(By.id("welcome")).getText();
		//Assert.assertEquals(message, "Welcome ");
	}

	

	

	@Then("I verify quick launch button")
	public void i_verify_quick_launch_button(DataTable table) {
		
		List<Map<String, String>> listTable = table.asMaps(String.class, String.class);
		
				for(Map<String, String> list: listTable) {
					String iconName = list.get("button");
					System.out.println(iconName);
					boolean status = WebDriverFactory.getDriver().findElement(By.xpath("//*[@class=\"quickLaunge\"]//span[text()='"+iconName+"']")).isDisplayed();
					Assert.assertTrue(status, iconName+ " quick option not available");
					
				}
		
	}
	
	@Then("I logout")
	public void i_logout() {
		WebDriverFactory.getDriver().findElement(By.id("welcome")).click();
		WebDriverFactory.getDriver().findElement(By.xpath("//a[text()='Logout']")).click();
	}

}
