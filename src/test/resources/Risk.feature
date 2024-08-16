Feature: Verify Risk scenarios for analytics webservices
  As a tester, I want to validate the Risk features

  @Regression
  Scenario: M3A00204 PostRiskRate Global
    Given user access to "RiskFreeRate" endpoint
    And build "RiskFreeRate Global" request header and json
    When user make a post call request
    Then Validate the response code "200" and type "application/json"
    And Validate the RiskFreeRate response value "0.43455"
#    here the response is small so directly validating the body