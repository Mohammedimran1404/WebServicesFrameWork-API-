Feature: Verify projectName Analytics
  As a tester, I want to validate the projectName Analytics features

  @Regression
  Scenario: Validate the Relative Code API post functionality
    Given user access to "Relative code" endpoint
    And build "Relative code" request header and json
    When user make a post call request
    Then Validate the response code "200" and type "application/json; charset=utf-8"

    @Regression
    Scenario: Validate the Characteristics Names API post functionality
      Given user access to "Characteristics Names" endpoint
      And build "Characteristics Names" request header and json
      When user make a post call request
      Then Validate the response code "200" and type "application/json; charset=utf-8"
      And Validate the "Characteristics Names" schema

  @Regression
  Scenario: Validate the Characteristics Properties Import API post functionality
    Given user access to "Characteristics Properties Import" endpoint
    And build "Characteristics Properties Import" request header and json
    When user make a post call request
    Then Validate the response code "200" and type "application/json; charset=utf-8"
    And Validate the "Characteristics Properties Import" response required values
    And Validate the "Characteristics Properties Import" schema
