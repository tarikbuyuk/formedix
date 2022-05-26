@wip
Feature: Editing data acquisition form in study repository

  Scenario: Login as a user to the application
    Given the user is on the login page
    When the user login with valid credentials
    When the user navigates to Repository->Studies
    Then the user enter the Tech Study view
    And the user enter the Data acquisition asset group
    And the user select to view Forms
    When the user select to view the Medical History
    And edit the form with "data" and save
    Then Logout of the application


