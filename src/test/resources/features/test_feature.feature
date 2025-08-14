@API_Verification
Feature: API verification

  @Get_Test
  Scenario: Verify api GET response
    Given user performed GET request for endpoint "api/users/2"
    Then response status code should be 200
    And response saved at responsefile
    And email should be "emailid" in response