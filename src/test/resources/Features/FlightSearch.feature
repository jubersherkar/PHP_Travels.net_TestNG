
@flightSearch
Feature: Verify flight search feature

  @oneway
  Scenario Outline: Search one way flight
    Given User is on home page
    And User clicks on flights tab
    And User clicks on One way option
    And User selects "<cabin>" Cabin class
    And User enters Origin as "<origin>"
    And User enters destination as "<destination>"
    And User selects date "<date>"
    And User selects <adult> Adults <child> Child and <infant> Infant
    When User clicks on Search button
    Then Available flights should be displayed

    Examples: 
      | origin  | destination | date  		 	|adult|child	|infant	|cabin	         |
      | LHR		  |     CDG 		| 30-09-2024 	|	2	 	| 1			|	0		 	|Economy Premium |
      |	CHI			|			AMS			|	02-10-2024	|	3	 	| 2			|	1			|Business				 |
      
