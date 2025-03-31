@remove
Feature: User Delete

  Scenario: Successful removal
    Given User is in the login page
    And user attempts login
    And Login is Validated
    When user deletes his account
    Then account is deleted