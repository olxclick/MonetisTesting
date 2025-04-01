Feature: create a new bank account

  Scenario: Successful account creation
    Given User is in the login page
    When user attempts login
    And Login is Validated
    When I click on new account button
    And I fill the details in the pop up and create account
    Then I validate the account creation