Feature: Verify date scenarios for analytics webservices
  As a tester, I want to validate the date features

  @Regression @date
  Scenario: D2U00805 PostRelativeCode- Domestic
    Given user access to "Relative code" endpoint
    And build "Relative code" request header and json with "1" relative date code "2016-12-30T21:22:20.758Z" base date "2" date amount "Global"
    When user make a post call request
    Then Validate the response code "200" and type "application/json; charset=utf-8"
    And Validate the "Relative code" response value "\"2017-01-03T00:00:00\""


