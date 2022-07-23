@google
Feature: To Verify Google Search works

  @smoke
  Scenario Outline: To Verify Search Results are fetched for keyword
    Given To be at Google Home Page
    When Search for <keyword> at Search Area
    Then Search Results should be loaded
    And Minimum <count> records should be loaded

    Examples:

      | keyword  | count |
      | christob | 3     |
      | Spring   | 5     |
      | Java     | 4     |