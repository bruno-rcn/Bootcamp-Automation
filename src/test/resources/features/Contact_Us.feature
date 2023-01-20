@contact-us
@regression
Feature: Webdriver University - Contact Us Page

  @validateContact
  Scenario: Validate Successful Submission
    Given I access the webdriver university contact us page
    When I enter a first name
    And I enter a last name
    And I enter an email address
    And I enter a comment
    And I click on the submit button
    Then I should be presented with a successful contact us submission message

  @validateContactVariable
  Scenario: Validate Successful Submission - Specific data
    Given I access the webdriver university contact us page
    When I enter a specific first name Bruno
    And I enter a specific last name "Noberto"
    And I enter a specific email address "brunorcnoberto@hotmail.com"
    And I enter a specific comment "Training cucumber, java & selenium!"
    And I click on the submit button
    Then I should be presented with a successful contact us submission message
