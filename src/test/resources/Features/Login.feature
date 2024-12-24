@login
Feature: Verify Login functionality

  
  Scenario Outline: Validate Login with valid username and password
    Given User enter base url as "https://phptravels.net/login"
    And User enteres user id as "<userName>"
    And User enteres Password as "<password>"
    When Click on login
    Then User should be logged in

    Examples: 
      | userName 							  | password |
      | remo.dsouza72@gmail.com | agentremo |

  Scenario Outline: Validate Login with invalid username and password
    Given User enter base url as "https://phptravels.net/login"
    And User enteres user id as "<userName>"
    And User enteres Password as "<password>"
    When Click on login
    Then User should be able to see error as "Invalid Login"

    Examples: 
      | userName 					| password |
      | me@phptravels.com |   123456 |
      |	me@phptravels.com	|					 |
      |										|					 |
      |										|	agentremo|
