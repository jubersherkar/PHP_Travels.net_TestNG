package com.snd.stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import com.snd.pageObjects.HomePage;
import com.snd.utilities.BaseClass;
import com.snd.utilities.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageSteps {

	TestContext testContext;
	HomePage homePage;

	private Logger log = LogManager.getLogger();

	public HomePageSteps(TestContext testContext)
	{
		this.testContext = testContext;
		homePage = testContext.getPageObjectManager().getHomePage();
	}

	@Given("User is on home page")
	public void user_is_on_home_page() {
		//		This is by pass for home page
		BaseClass baseClass = testContext.getPageObjectManager().getBaseClass();
		baseClass.enterBaseUrl();
		log.info("Entered base URL");
		log.info("Translated to English");
	}
	@Given("Check for products like Flights,Hotels,Tours,Cars presence")
	public void check_for_products_like_flights_hotels_tours_cars_presence() {
		Assert.assertTrue(homePage.verifyPresenceOfProducts());
		log.info("Product presence is verified");
	}
	@Given("Check for One way and Round trip options")
	public void check_for_one_way_and_round_trip_options() {
		Assert.assertTrue(homePage.verifyPresenceOfTripOptions());
		log.info("Trip options is verified");
	}
	@When("User clicks on cabin class dropdown to check options")
	public void user_clicks_on_cabin_class_dropdown_to_check_options() {
		Assert.assertEquals(homePage.verifyCabinClass(2).getText(),"Business");
		log.info("Cabin class drop down verified");
	}
	@When("Check for Origin,Destination,Departure date,Travellers,Search button")
	public void check_for_origin_destination_departure_date_travellers_search_button() {
		Assert.assertTrue(homePage.verifyPresenceOfOriginDestinationDateTravellerSearch());
		log.info("Verified presence of Origin, Destination, Departure date, Travellers, Search button");
	}
	@Given("Check for PHPTRAVELS logo")
	public void check_for_phptravels_logo() {
		Assert.assertTrue(homePage.verifyPresenceOfLogo());
		log.info("Verified presence of logo");
	}
	@When("User clicks on language dropdown to validate options")
	public void user_clicks_on_language_dropdown_to_validate_options() {
		Assert.assertTrue(homePage.verifyPresenceOfLanguageDropDown());
		log.info("Verified language drop down");
	}
	@When("User clicks on currency dropdown to validate options")
	public void user_clicks_on_currency_dropdown_to_validate_options() {
		Assert.assertTrue(homePage.verifyPresenceOfCurrencyDropDown());
		log.info("Verified Curremcy drop down");
	}
	@Then("User clicks on Account dropdown to validate options")
	public void user_clicks_on_account_dropdown_to_validate_options() {
		Assert.assertTrue(homePage.verifyPresenceOfAccountDropDown());
		log.info("Verified account drop down");
	}

	@Given("Check for agent Contact number and Email")
	public void check_for_agency_contact_number_and_email() {
		Assert.assertTrue(homePage.verifyContactDetailsInFooter());
		log.info("Verified Agent contact details ");
	}
	@Given("Check for Name,Email,Sign up Newsletter presence")
	public void check_for_name_email_sign_up_newsletter_presence() {
		Assert.assertTrue(homePage.verifyPresenceOfNameEmailSignUpNewsletter());
		log.info("Verified presence of Name, Email, Sign up Newsletter");
	}
	@Given("Check for Disclaimer,bottom logo,media icons presence")
	public void check_for_disclaimer_bottom_logo_media_icons_presence() {
		Assert.assertTrue(homePage.verifyPresenceOfFooters());
		log.info("Verified presence of Disclaimer, Bottom logo, Media icons");
	}
	@Given("User clicks on flights tab")
	public void user_clicks_on_flights_tab() {
		homePage.clickOnFlightsTab();
	    log.info("Clicked on Flights tab");
	}
	@Given("User clicks on One way option")
	public void user_clicks_on_one_way_option() {
	   homePage.clickOnOneWay();
	   log.info("Clicked on one way option");
	}
	@Given("user clicks on round trip option")
	public void user_clicks_on_round_trip_option() {
		homePage.clickOnRoundTrip();
	    log.info("user clicked on round trip option");
	}
	@Given("User selects {string} Cabin class")
	public void user_selects_cabin_class(String string) {
		homePage.selectCabin(string);
		log.info("Cabin class selected");
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
	@Given("User selects depart date {string}")
	public void user_selects_depart_date(String string) {
	   homePage.enterDepartDate(string);
	   log.info("Entered depart date");
	}
	@Given("User selects return date {string}")
	public void user_selects_return_date(String string) {
	    homePage.enterReturnDate(string);
		log.info("Entered return date");
	}
	@Given("User selects {int} Adults {int} Child and {int} Infant")
	public void user_selects_adults_child_and_infant(Integer int1, Integer int2, Integer int3) {
	   homePage.clickOnTravellersDropDown();
	   log.info("Clicked on travellers drop down");
	   homePage.selectTraveller(int1, int2, int3);
	   log.info("Selected travellers");
	}
	@When("User clicks on Search button")
	public void user_clicks_on_search_button() {
	   homePage.clickSearch();
	   log.info("Clicked on search button");
	}
	@Then("Available flights should be displayed")
	public void available_flights_should_be_displayed() {
		Assert.assertEquals(homePage.getPageTitle(), "Flights Result");
	    log.info("Verified Flight search");
	}
}