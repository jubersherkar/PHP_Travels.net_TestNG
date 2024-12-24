package com.snd.runners;

import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/Features",
		glue = {"com.snd.stepDefinitions"},				
		plugin = {"pretty",
				"html:target/cucumber-reports/cucumber-pretty",
				"json:target/cucumber-reports/CucumberTestReport.json",
				"rerun:target/cucumber-reports/rerun.txt",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				},
		tags = "not @login",
		monochrome = true,
		dryRun = false )

public class TestRunner extends AbstractTestNGCucumberTests
{
		@Override
		@DataProvider(parallel = false)
		public Object[][] scenarios() {
			return super.scenarios();
		}
}	// mvn clean test -Dcucumber.filter.tags="@login"
	// mvn clean test -Dcucumber.features="src/test/resources/features/HomePage.feature"
	// mvn clean test -Dcucumber.plugin="html:target/cucumber-reports/cucumberReport.html"
	// mvn clean test -Dcucumber.features="src/test/resources/features/LoginPage.feature" -Dcucumber.filter.tags="@ValidCredentials"	
		