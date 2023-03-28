Feature: user able to clear all entered fields by using "Clear" button in CarbonHydrate Calculator

  Background:
    When user clicks on "Fitness & Health Calculators"
    Then user clicks on option "Carbohydrate Calculator"

  @TC_032
  Scenario: Verify functionality of "Clear" Button
    When user click on "US Units" option
    And user enters "80" in Age
    And user clicks on "Male" gender
    And user enters "7" into feets
    And user enters "10" into inches
    And user enters "30" into pounds
    And user selects "Very Active: intense exercise 6-7 times/week"
    And user clicks on Settings
    And user clicks on "Katch-McArdle" option
    And user clicks on Clear button
    Then all entered fields age, feets, inches, pounds should be empty