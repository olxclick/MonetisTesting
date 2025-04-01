Feature: Make a Transfer to own account

  Scenario: Successful transfer
    Given User is in the login page
    When user attempts login
    Then Login is Validated
    Given I store the balance before the transfer
    When I select transfer to own account
    And I fill in the form and click on next
    Then Verify success transfer page appears
    When I access accounts page
    Then verify savings account balance increased

