@login
@regression
Feature: Webdriver University - Login Page

  Background:
    Given I access the webdriver university login page

  @validateLogin
  Scenario Outline: Validate - Successful and Unsuccessful login
    And I enter a username <username>
    And I enter a password <password>
    When I click on the login button
    Then I should be presented with the message <message>

    Examples:
      | username  | password           | message              |
      | webdriver | webdriver123       | validation succeeded |
      | webdriver | webdriverIncorrect | validation failed    |
      | wdddriver | webdriver123       | validation failed    |
