Feature: user able to navigate to related calculators from CarbonHydrate calculator

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