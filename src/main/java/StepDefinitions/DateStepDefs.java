package StepDefinitions;

import Utilities.RequestBodyUtils;
import Utilities.RequestHeaderUtils;
import Utilities.ScenarioUtils;
import io.cucumber.java.en.And;
import org.testng.Assert;

public class DateStepDefs {
    ScenarioUtils scenarioUtils;

    public DateStepDefs(ScenarioUtils scenarioUtils){
        this.scenarioUtils=scenarioUtils;
    }
    @And("build {string} request header and json with {string} relative date code {string} base date {string} date amount {string}")
    public void build_request_header_and_json_with_relative_date_code_base_date_date_amount(String strEndPoint, String strRelativeCode, String strBaseDate, String strDateAmount, String strRegion) {
        switch (strEndPoint){
            case "Relative code":
                this.scenarioUtils.getScenarioContext().headers= RequestHeaderUtils.getBasicHeader();
                if(strRegion.toUpperCase().equalsIgnoreCase("GLOBAL")){
                    this.scenarioUtils.getScenarioContext().requestBody= RequestBodyUtils.relativeCode(strRelativeCode,strBaseDate,strDateAmount,true);// posting data using json
                }
                else{
                    this.scenarioUtils.getScenarioContext().requestBody= RequestBodyUtils.relativeCode(strRelativeCode,strBaseDate,strDateAmount,false);
                }
        }

    }
    @And("Validate the {string} response value {string}")
    public void validate_the_response_value(String strEndPoint, String strValue) {
        switch (strEndPoint){
            case "PortfolioAccess":
            case "Relative code":
                Assert.assertEquals(this.scenarioUtils.getScenarioContext().response.getBody().asString(),strValue);
                break;
            default:
                Assert.fail("Given Endpoint isnt present in the condition");
        }

    }

}
