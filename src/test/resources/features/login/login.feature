Feature: Login in practice site
  @Login
  Scenario: Successful login
    Given User is in the login page
    When User logins with valid credential
    Then User user should be able to login
