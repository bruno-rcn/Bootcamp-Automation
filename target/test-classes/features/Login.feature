@login
Feature: Webdriver University - Login Page

  Scenario: Validate Successful Login
    Given I access the webdriver university login page
    And I enter a username "webdriver"
    And I enter a password "webdriver123"
    When I click on the login button
    Then I should be presented with the successful login message

  Scenario: Validate Unsuccessful Login
    Given I access the webdriver university login page
    And I enter a username "webdriver"
    And I enter a password "webdriverIncorrect"
    When I click on the login button
    Then I should be presented with the unsuccessful login message