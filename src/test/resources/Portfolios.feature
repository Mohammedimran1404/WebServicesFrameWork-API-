Feature: Verify Portfolios scenarios for analytics webservices
  As a tester, I want to validate the Portfolios features


  @Regression
  Scenario: P200104 PostPortfolios
    Given user access to "RiskFreeRate" endpoint
    And build "Portfolios" request header and json with "acctapge" account "Global"
    When user make a post call request
    Then Validate the response code "200" and type "application/json"
#    this validation is used for validating the response body values using pojo classes
    And Validate the portfolio response required values
      |APGE|Real|acctapge|APG Global Portfolio|40098|
    And Validate the "Portfolio" schema
    And Validate the portfolio dates response format
