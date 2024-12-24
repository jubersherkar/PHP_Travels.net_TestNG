@flightSearch
Feature: Verify flight search feature

  @oneWaySearch
  Scenario Outline: Search one way flights
    Given User is on home page
    And User clicks on flights tab
    And User clicks on One way option
    And User selects "<cabin>" Cabin class
    And User enters Origin as "<origin>"
    And User enters destination as "<destination>"
    And User selects depart date "<depart_date>"
    And User selects <adult> Adults <child> Child and <infant> Infant
    When User clicks on Search button
    Then Available flights should be displayed

    Examples: 
      | origin | destination | depart_date| adult | child | infant | cabin    |
      | LHR    | CDG         | 30-01-2025 |     2 |     1 |      0 | Economy  |
      | CHI    | AMS         | 02-02-2025 |     3 |     2 |      1 | Business |

  @roundTripSearch
  Scenario Outline: Search round trip flights
    Given User is on home page
    And User clicks on flights tab
    And user clicks on round trip option
    And User selects "<cabin>" Cabin class
    And User enters Origin as "<origin>"
    And User enters destination as "<destination>"
    And User selects depart date "<depart_date>"
    And User selects return date "<return_date>"
    And User selects <adult> Adults <child> Child and <infant> Infant
    When User clicks on Search button
    Then Available flights should be displayed

    Examples: 
      | origin | destination | depart_date| return_date | adult | child | infant | cabin    |
      | LHR    | CDG         | 30-01-2025 | 15-02-2025  |  2 		|     0 |      0 | Economy  |
      | LHR    | CDG         | 30-01-2025 | 15-02-2025  |  2 		|     1 |      0 | Business |