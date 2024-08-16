package StepDefinitions;

import Utilities.RequestBodyUtils;
import Utilities.RequestHeaderUtils;
import Utilities.ScenarioUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MiscDateStepDefs {
    ScenarioUtils scenarioUtils;

    public MiscDateStepDefs(ScenarioUtils scenarioUtils) {
        this.scenarioUtils = scenarioUtils;
    }

    @And("build the request header and json using data table values")
    public void build_the_request_header_and_json_using_data_table_values(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String strType = data.get(0).get("type");

        switch (strType) {
            case "FindSymbol": {
                String strsymbol = data.get(0).get("symbol");
                if (strsymbol.equalsIgnoreCase("[blank]")) strsymbol = "";
                String strSymbolTypeChar = data.get(0).get("symbolTypeChar");
                String strDate = data.get(0).get("date");
                if (strDate.equalsIgnoreCase("[blank]")) strDate = "";
                String strcountry = data.get(0).get("country");
                if (strcountry.equalsIgnoreCase("[blank]"))
                    strcountry = "";
                String strreqId = data.get(0).get("requestId");
                if (strreqId.equalsIgnoreCase("[blank]"))
                    strreqId = "";

                boolean blnIsGlobal = Boolean.parseBoolean(data.get(0).get("isGlobal"));
                this.scenarioUtils.getScenarioContext().headers = RequestHeaderUtils.getBasicHeader();
                this.scenarioUtils.getScenarioContext().requestBody = RequestBodyUtils.findSymbol(strsymbol, strSymbolTypeChar, strDate, strcountry, strreqId, blnIsGlobal);
                break;
            }
            case "FactorReturns":{
//                again same data what is required
            }

        }

    }
    @And("Validate the {string} attribute has the {string} value")
    public void validate_the_attribute_has_the_value(String strAttribute, String strValue) {
        JsonPath jsonPath=this.scenarioUtils.getScenarioContext().response.jsonPath();
        Assert.assertTrue(jsonPath.get(strAttribute).toString().contains(strValue));

    }
    @And("Validate the factor returns response data type")
    public void validate_the_factor_returns_response_data_type(){
        JsonPath jsonPath=new JsonPath(this.scenarioUtils.getScenarioContext().response.getBody().asString());
        ArrayList<Double> list =new ArrayList<>(jsonPath.get());
        Assert.assertNotNull(list);
    }


}
