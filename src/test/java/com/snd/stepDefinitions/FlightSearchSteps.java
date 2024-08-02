package com.snd.stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.snd.pageObjects.HomePage;
import com.snd.utilities.TestContext;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FlightSearchSteps 
{
	TestContext testContext;
	HomePage homePage;
	WebDriverWait wait;

	private Logger log = LogManager.getLogger();
	
	public FlightSearchSteps(TestContext context)
	{
		this.testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
	}
	
	@Given("User clicks on flights tab")
	public void user_clicks_on_flights_tab() {
	    homePage.transaleToEnglish();
	    log.info("Translated to English");
		homePage.clickOnFlightsTab();
	    log.info("Clicked on Flights tab");
	}
	@Given("User clicks on One way option")
	public void user_clicks_on_one_way_option() {
	   homePage.clickOnOneWay();
	   log.info("Clicked on one way option");
	}
	@Given("User enters Origin as {string}")
	public void user_enters_origin_as(String string) {
	    homePage.enterOrigin(string);
	    log.info("Entered origin");
	}
	@Given("User enters destination as {string}")
	public void user_enters_destination_as(String string) {
		homePage.enterDestination(string);
		log.info("Destination entered");
	}
	@Given("User selects date {string}")
	public void user_selects_date(String string) {
	   homePage.enterDate(string);
	   log.info("Entered date");
	}
	@Given("User selects {int} Adults {int} Child and {int} Infant")
	public void user_selects_adults_child_and_infant(Integer int1, Integer int2, Integer int3) {
	   homePage.clickOnTravellersDropDown();
	   log.info("Clicked on travellers drop down");
	   homePage.selectTraveller(int1, int2, int3);
	   log.info("Selected travellers");
	}
	@Given("User selects {string} Cabin class")
	public void user_selects_cabin_class(String string) {
		homePage.selectCabin(string);
		log.info("Cabin class selected");
	}
	@When("User clicks on Search button")
	public void user_clicks_on_search_button() {
	   homePage.clickSearch();
	   log.info("Clicked on search button");
	}
	@Then("Available flights should be displayed")
	public void available_flights_should_be_displayed() {
	    String label = homePage.getFlightsFoundLabel().getText();
	    Assert.assertTrue(label.contains("Flights Found"));
	    log.info("Verified Flight search");
	}
}
