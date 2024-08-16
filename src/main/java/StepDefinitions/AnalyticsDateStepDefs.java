package StepDefinitions;

import DriverManagers.ConfigFileManager;
import Pages.CharacteristicsPropertiesImport;
import Utilities.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class AnalyticsDateStepDefs {

    ScenarioUtils scenarioUtils;

    public AnalyticsDateStepDefs(ScenarioUtils scenarioUtils){
        this.scenarioUtils=scenarioUtils;
    }

    /**
     * Method to get the access of base url and end point
     * @param strEndPointType
     */
    @Given("user access to {string} endpoint")
    public void user_access_to_endpoint(String strEndPointType) {
        String strBaseURL,strEndPoint;
        switch (strEndPointType){
            case "Relative code":
                strBaseURL= ConfigFileManager.getInstance().getReadConfig().getBaseURL();
                strEndPoint=ConfigFileManager.getInstance().getReadConfig().getRelativeCodeEndPoint();
                this.scenarioUtils.getScenarioContext().strBaseURL=strBaseURL;
                this.scenarioUtils.getScenarioContext().strEndPoint=strEndPoint;
                break;
            case "Characteristics Names":
                strBaseURL=ConfigFileManager.getInstance().getReadConfig().getBaseURL();
                strEndPoint=ConfigFileManager.getInstance().getReadConfig().getCharacteristicsNamesEndPoint();
                this.scenarioUtils.getScenarioContext().strBaseURL=strBaseURL;
                this.scenarioUtils.getScenarioContext().strEndPoint=strEndPoint;
                break;
        }

    }

    /**
     * Method to send the request body and headers
     * if the two case values are same means no need to add the data for any one of them
     * just writing the case
     * @param strEndPoint
     */
    @And("build {string} request header and json")
    public void build_request_header_and_json(String strEndPoint) {
        switch (strEndPoint){
            case "Relative code":
                this.scenarioUtils.getScenarioContext().headers= RequestHeaderUtils.getBasicHeader();
                this.scenarioUtils.getScenarioContext().requestBody= RequestBodyUtils.relativeCodeRequestBody();
                break;
            case "Characteristics Properties Import": // both data of 2 and 3 case are same no need to write again just add the case.
            case "VariancePRLSLong":
                this.scenarioUtils.getScenarioContext().headers=RequestHeaderUtils.getBasicHeader();
                this.scenarioUtils.getScenarioContext().requestBody= ReadJSONUtils.readRequestJSON(strEndPoint);
        }

    }
    @When("user make a post call request")
    public void user_make_a_post_call_request() {
        this.scenarioUtils.getScenarioContext().response= ReusableMethodUtils.postMethod(this.scenarioUtils.getScenarioContext().strBaseURL,
               this.scenarioUtils.getScenarioContext().strEndPoint,this.scenarioUtils.getScenarioContext().headers,this.scenarioUtils.getScenarioContext().requestBody);

    }
    @Then("Validate the response code {string} and type {string}")
    public void validate_the_response_code_and_type(String strResponseCode, String strResponseType) {
        ValidationUtils.validateResponseCode(this.scenarioUtils.getScenarioContext().response,strResponseCode);
        ValidationUtils.validateResponseType(this.scenarioUtils.getScenarioContext().response,strResponseType);

    }
    @And("Validate the {string} schema")
    public void validate_the_schema(String strSchemaType) {
        ValidationUtils.validateSchema(this.scenarioUtils.getScenarioContext().response,strSchemaType);

    }
    @And("Validate the {string} response required values")
    public void validate_the_response_required_values(String strEndPoint) {
        switch (strEndPoint){
            case "Characteristics Properties Import":
                CharacteristicsPropertiesImport characteristicsPropertiesImport=ResponseUtils.getResponse(this.scenarioUtils.getScenarioContext().response,CharacteristicsPropertiesImport.class);
                Assert.assertNotNull(characteristicsPropertiesImport,"Characteristics Properties Import created");
                Assert.assertEquals(characteristicsPropertiesImport.getLoadErrorCode(),0,"load error code validation");
                Assert.assertEquals(characteristicsPropertiesImport.getFileOutput(),null,"file output validation");
                break;
        }

    }
    @And("Validate the expected {string} response with actual")
    public void validate_the_expected_response_with_actual(String strResponse) {
       String strExpected=null;
       switch (strResponse){
           case "Attribution":
               strExpected=ReadJSONUtils.readResponseJSON(strResponse).toString();
               break;
       }
       Assert.assertEquals(this.scenarioUtils.getScenarioContext().response.getBody().asString(),strExpected);
    }
    @And("Validate the RiskFreeRate response value {string}")
    public void validate_the_risk_free_rate_response_value(String strValue) {
        Assert.assertEquals(this.scenarioUtils.getScenarioContext().response.getBody().asString(),strValue);
    }



}
