Feature: Dashboard functionality Carbohydrate Calculator

  Background:
    When user clicks on "Fitness & Health Calculators"
    Then user clicks on option "Carbohydrate Calculator"


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
