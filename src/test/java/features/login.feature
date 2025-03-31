@login
Feature: User Login

    Scenario: Successful login
      Given User is in the login page
      When user attempts login
      Then Login is Validated