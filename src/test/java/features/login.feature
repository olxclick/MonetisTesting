Feature: User Login

    Scenario: Successful login
      Given User is in the landing page
      When user logs into the app
      Then Dashboard is displayed