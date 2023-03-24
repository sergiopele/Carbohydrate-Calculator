Feature: Dashboard functionality Carbohydrate Calculator

  Background:
    When user clicks on "Fitness & Health Calculators"
    Then user clicks on option "Carbohydrate Calculator"

  @TC_034
  Scenario Outline: Verify Buttons in "Carbohydrate Calculator"
  in section "Related" should navigate to intended destination on the same tab
    When user clicks on button "<button>"
    Then verify title "<title>"
    Examples:
      | button                | title                 |
      | Calorie Calculator    | Calorie Calculator    |
      | Protein Calculator    | Protein Calculator    |
      | Fat Intake Calculator | Fat Intake Calculator |

  @TC_035
  Scenario Outline: Verify Dashboard all dashboard tabs in "Carbohydrate Calculator"
  and they should navigate to intended destination on the same tab
    When user clicks on dashboard tab "<tab>"
    Then verify tab title "<title>"
    Examples:
      | tab              | title                          |
      | FINANCIAL        | Financial Calculators          |
      | FITNESS & HEALTH | Fitness and Health Calculators |
      | MATH             | Math Calculators               |
      | OTHER            | Other Calculators              |

@TC_032
Scenario: Verify functionality of "Clear" Button
  When user click on "US Units" option
  And user enters 80 in Age
  And user clicks on "Male" gender
  And user enters 7 into feets
  And user enters 10 into inches
  And user enters 30 into pounds
  And user selects "Very Active: intense exercise 6-7 times/week"
  And user clicks on Settings
  And user clicks on "Katch-McArdle" option
  And user clicks on Clear button
  Then all entered fields age, feets, inches, pounds should be empty