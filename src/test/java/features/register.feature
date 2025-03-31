@create
Feature: User Registration

  Scenario: Valid Registration
    Given user is on the registration page
    When user attempts registration
    Then Registration is Validated