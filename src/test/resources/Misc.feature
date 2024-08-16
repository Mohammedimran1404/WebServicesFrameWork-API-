Feature: Verify Misc scenarios for analytics webservices
  As a tester, I want to validate the Misc features
  
  @Regression
  Scenario: M3A00202 PostFindSymbolC - Global
   Given user access to "FindSymbol" endpoint
    And build the request header and json using data table values
    |type|symbol|symbolTypeChar|date|country|isGlobal|requestId|
    |FindSymbol|G1654|c    |2024-08-15|[blank]|true|           222|
    When user make a post call request
    Then Validate the response code "200" and type "application/json"
    And Validate the "FindSymbol" response value "500095"

  @Regression
  Scenario: M3A00204 PostAttribution Global
    Given user access to "FindSymbol" endpoint
    And build "AttributionAPGE" request header and json
    When user make a post call request
    Then Validate the response code "200" and type "application/json"
    And Validate the "Attribution" schema
    And Validate the expected "Attribution" response with actual

  @Regression
  Scenario: M3A00204 PostAttribution Global
    Given user access to "FindSymbol" endpoint
    And build "AttributionAPGE_benchMark" request header and json
    When user make a post call request
    Then Validate the response code "500" and type "application/json"
    And Validate the "errorMessage" attribute has the "'Portfolio option' must be equal to 'Benchmark''" value

  @Regression
  Scenario: M3A00204 PostAttribution Global
    Given user access to "FactorReturns" endpoint
    And build "AttributionAPGE_benchMark" request header and json
    When user make a post call request
    Then Validate the response code "200" and type "application/json"
    And Validate the factor returns response data type
