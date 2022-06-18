@UI
Feature: Login in practice site

  @Login1
  Scenario: Successful login1
    Given User is in the login page
    When User logins with valid credential
    Then User user should be able to login

  @Login2
  Scenario: Successful login2
    Given User is in the login page
    When User logins with valid credential
    Then User user should be able to login
