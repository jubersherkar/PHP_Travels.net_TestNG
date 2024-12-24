package com.snd.stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import com.snd.pageObjects.FlightSearchResultPage;
import com.snd.utilities.TestContext;
import io.cucumber.java.en.Given;

public class FlightSearchResultSteps 
{
	TestContext testContext;
	FlightSearchResultPage flightSearchResultPage;
	private Logger log = LogManager.getLogger();

	public FlightSearchResultSteps(TestContext testContext)
	{
		this.testContext = testContext;
		flightSearchResultPage = testContext.getPageObjectManager().getFlightSearchResultPage();
	}
	@Given("Validate Airline logo is present")
	public void validate_airline_logo_is_present() {
		Assert.assertTrue(flightSearchResultPage.getDepartureFlightAirlineLogo().isDisplayed() &&
				flightSearchResultPage.getArrivalFlightAirlineLogo().isDisplayed());
		log.info("Validated airline logo.");
	}
	@Given("Validate flight number is present")
	public void validate_flight_number_is_present() {
		Assert.assertTrue(flightSearchResultPage.getDepartureFlightNumber().isDisplayed() &&
				flightSearchResultPage.getArrivalFlightNumber().isDisplayed());
		log.info("Validated flight numbers.");
	}
	@Given("Validate trip duration is displayed")
	public void validate_trip_duration_is_displayed() {
		Assert.assertTrue(flightSearchResultPage.getDepartureFlightDuration().isDisplayed() && 
				flightSearchResultPage.getArrivalFlightDuration().isDisplayed());
		log.info("Validated trip duration.");
	}
	@Given("Validate flight stops is displayed")
	public void validate_flight_stops_is_displayed() {
		Assert.assertTrue(flightSearchResultPage.getDepartureFlightStops().isDisplayed() &&
				flightSearchResultPage.getArrivalFlightStops().isDisplayed());
		log.info("Validated flight stops.");
	}
	@Given("Validate connecting airports are displayed")
	public void validate_connecting_airports_are_displayed() {
		Assert.assertTrue(flightSearchResultPage.getDepartureFlightConnections().isDisplayed() &&
				flightSearchResultPage.getArrivalFlightConnections().isDisplayed());
		log.info("Validated connecting airports");
	}
	@Given("Validate starting fare is displayed")
	public void validate_starting_fare_is_displayed() {
		Assert.assertTrue(flightSearchResultPage.getfareStartFrom().isDisplayed());
		log.info("Validated starting fare");
	}
	@Given("Validate More Details button is displayed")
	public void validate_more_details_button_is_displayed() {
		Assert.assertTrue(flightSearchResultPage.getMoreDetailsButton().isEnabled());
		log.info("Validated More Details button");
	}
	@Given("Validate Select flight button is displayed")
	public void validate_select_flight_button_is_displayed() {
		Assert.assertTrue(flightSearchResultPage.getSelectFlightButton().isEnabled());
		log.info("Validated Select Flight button");
	}
}
