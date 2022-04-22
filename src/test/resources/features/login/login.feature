Feature: Login in practice site
  @SmokeTest1
  Scenario: Login with valid credential
    Given User is in the login page
    When User logins with valid credential
    Then User should be able to login
  @SmokeTest2
  Scenario: Login with invalid credential
    Given User is in the login page
    When User logins with invalid credential
    Then User should not be able to login