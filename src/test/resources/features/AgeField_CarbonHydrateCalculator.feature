Feature: user able to specify age from 18 to 80 years in "Age" field to get precise calculation result

  Background:
    When user clicks on "Fitness & Health Calculators"
    Then user clicks on option "Carbohydrate Calculator"

  @TC_001
  Scenario Outline: Verify that the Metric Unit Calculator accepts
  valid numeric inputs in "Age" field
    When user click on "Metric Units" option
    And user enters "<Age>" in Age
    And user enters "100" into Height
    And user clicks on "Male" gender
    And user enters "80" into Weight
    And user clicks on Calculate
    Then error message "Please provide an age between 18 and 80." should NOT be displayed on the top of calculator
    Examples:
      | Age |
      | 18  |
      | 21  |
      | 30  |
      | 60  |
      | 71  |
      | 80  |

  @TC_002
  Scenario Outline: Verify that the Metric Unit Calculator handle
  invalid numeric value in "Age" field
    When user click on "Metric Units" option
    And user enters "<Age>" in Age
    And user enters "111" into Height
    And user clicks on "Female" gender
    And user enters "50" into Weight
    And user clicks on Calculate
    Then error message "Please provide an age between 18 and 80." should be displayed on the top of calculator
    Examples:
      | Age          |
      | 17           |
      | 81           |
      | 80 0         |
      | 1,8          |
      | 18 0         |
      | 8,0          |
      | 10000        |
      | 999          |
      | 0018         |
      | 0080         |
      | 1.234.567,89 |