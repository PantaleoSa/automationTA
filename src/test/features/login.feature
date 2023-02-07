Feature: Feature to test functionality
  @login
  Scenario: Check login functionality
    Given User is on login page
    When User enters username and password
    And Click on login button
    Then User navigates to the homepage