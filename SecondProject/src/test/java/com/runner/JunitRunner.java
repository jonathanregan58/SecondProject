package com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)


/*@CucumberOptions(features="src/test/resources/Features", glue= {"pages"},
plugin = {"pretty","junit:target/JUnitReports/report.xml",
		"json:target/JSONReports/report.json",
		"html:target/HtmlReports"

},
tags= {"@HomeToRegister, @Register"}
)
*/

@CucumberOptions(


//features = {"src\\test\\resources\\Features\\hometoregisterorlogin.feature",
//"src\\test\\resources\\Features\\register.feature"}
//,
//glue= {"pages"},
/*plugin = { "pretty", "html:target/htmlreports" }
 */
//plugin = {"json:target/cucumber.json"}
//,
/*tags= "@Home and @HomeToRegister or @Register"
*/
//tags= "@HomeToRegister"
//)
	

		/*
features = {"src\\test\\resources\\Features\\registerwithexcel.feature"}
,
glue= {"pages"},
//plugin = { "pretty", "html:target/htmlreports" }
plugin = {"json:target/cucumber.json"}
,
tags= "@RegisterWithExcel2"
)
*/

//features = {"src\\test\\resources\\Features\\registerwithexcel.feature"}
		
features = {"src\\test\\resources\\Features\\login_.feature","src\\test\\resources\\Features\\jcpenney.feature"}
,
glue= {"com.steps"},
plugin = {"pretty","html:target/cucumber-Report","json:target/report.json"}
,
tags= "@OragHRM"
)

public class JunitRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
