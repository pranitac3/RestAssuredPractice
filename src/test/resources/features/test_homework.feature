@API_Verification
Feature: API verification

  @Homework
  Scenario: Homework Execution
    Given user performed single users request
    Then response status code should be 200
    And page numbers should be "2"
    And email should be "michael.lawson@reqres.in" in response

