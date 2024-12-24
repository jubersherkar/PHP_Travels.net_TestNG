@homePage
Feature: Verify Dashboard

  @headers
  Scenario: Verify headers on dashboard
    Given User is on home page
    And Check for PHPTRAVELS logo
    And Check for products like Flights,Hotels,Tours,Cars presence
    When User clicks on language dropdown to validate options
    And User clicks on currency dropdown to validate options
    Then User clicks on Account dropdown to validate options
    

  @flights
  Scenario: Verify Serach widget
    Given User is on home page
    When User clicks on flights tab
    Then Check for One way and Round trip options
    And User clicks on cabin class dropdown to check options
    And Check for Origin,Destination,Departure date,Travellers,Search button
    
  @footers
  Scenario: Verify Footers
  	Given User is on home page
  	And Check for agent Contact number and Email
  	And Check for Name,Email,Sign up Newsletter presence
  	And Check for Disclaimer,bottom logo,media icons presence 

  