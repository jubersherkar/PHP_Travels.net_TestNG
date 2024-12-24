@flightSearchResult
Feature: Verify flights search result page

Background: User search for for round trip flights
		Given User is on home page
    And User clicks on flights tab
    And user clicks on round trip option
    And User selects "Economy" Cabin class
    And User enters Origin as "LHR"
    And User enters destination as "CDG"
    And User selects depart date "30-01-2025"
    And User selects return date "15-02-2025"
    And User selects 2 Adults 0 Child and 0 Infant
    When User clicks on Search button
 
  @flightsCard
  Scenario: Verify flights card on result page
    Given Validate Airline logo is present
    And Validate flight number is present
    And Validate trip duration is displayed
    And Validate flight stops is displayed
    And Validate connecting airports are displayed
    And Validate starting fare is displayed
    And Validate More Details button is displayed
    And Validate Select flight button is displayed
