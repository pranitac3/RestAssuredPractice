@API_Verification
Feature: API verification

  @POST_Test
  Scenario: Verify api POST response
    Given user performed POST request for endpoint "api/users" with body from "src/test/resources/request/request.json"
    Then response status code should be 201
    And response saved at "src/test/resources/response/response1.json"
