package StepDefinitions;

import Pages.Portfolio;
import Utilities.RequestBodyUtils;
import Utilities.RequestHeaderUtils;
import Utilities.ResponseUtils;
import Utilities.ScenarioUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en_scouse.An;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PortfoliosStepDefs {
    ScenarioUtils scenarioUtils;
    public PortfoliosStepDefs(ScenarioUtils scenarioUtils){
        this.scenarioUtils=scenarioUtils;
    }
    @And("build {string} request header and json with {string} account {string}")
    public void build_request_header_and_json_with_account(String strEndPoint, String strAccount, String strRegion) {
        switch (strEndPoint){
            case "Portfolios":
                this.scenarioUtils.getScenarioContext().headers= RequestHeaderUtils.getBasicHeader();
                if(strRegion.toUpperCase().equalsIgnoreCase("GLOBAL")) {
                    this.scenarioUtils.getScenarioContext().requestBody= RequestBodyUtils.portfolio(strAccount,true);
                } else {
                    this.scenarioUtils.getScenarioContext().requestBody= RequestBodyUtils.portfolio(strAccount,false);

                }
        }

    }
    @And("Validate the portfolio response required values")
    public void validate_the_portfolio_response_required_values(DataTable dataTable) {
        List<List<String>> data=dataTable.asLists();
        Portfolio portfolios= ResponseUtils.getResponse(this.scenarioUtils.getScenarioContext().response,Portfolio.class);
        Assert.assertNotNull(portfolios,"Portfolio created");
        Assert.assertNotNull(portfolios.getLastValidDate());
        Assert.assertNotNull(portfolios.getAccountNumber());
        Assert.assertEquals(portfolios.getLongName(),data.get(0).get(4));
        Assert.assertNotNull(portfolios.getCode1());
        Assert.assertNotNull(portfolios.getCode2());
        Assert.assertNotNull(portfolios.getCode3());
        Assert.assertNotNull(portfolios.getCode4());
        Assert.assertNotNull(portfolios.getBenchmark());
        Assert.assertNotNull(portfolios.getFirstDate());
        if(!data.get(0).get(2).equalsIgnoreCase("[blank]"))
            Assert.assertEquals(portfolios.getCountryProfile(),data.get(0).get(2));
        else
            Assert.assertEquals(portfolios.getCountryProfile(),"");

        if(!data.get(0).get(0).equalsIgnoreCase("[blank]"))
            Assert.assertEquals(portfolios.getManagerName(),data.get(0).get(0));

        else
            Assert.assertEquals(portfolios.getManagerName(),"");
        Assert.assertNotNull(portfolios.getTitle1());
        Assert.assertNotNull(portfolios.getTitle2());
        Assert.assertEquals(portfolios.getLongName(),data.get(0).get(1));
        Assert.assertNotNull(portfolios.getUnderLyingId());
        Assert.assertEquals(portfolios.getShortName(),data.get(0).get(3));
        Assert.assertEquals(portfolios.getPortfolioId(),Long.parseLong(data.get(0).get(5)));
    }

    @And("Validate the portfolio dates response format")
    public void validate_the_portfolio_dates_response_format(){
        JsonPath jsonPath=new JsonPath(this.scenarioUtils.getScenarioContext().response.getBody().asString());
        ArrayList<Date> list=new ArrayList<>(jsonPath.get());
        DateFormat inputFormat=new SimpleDateFormat("yyyyy-mm-dd'T'hh:mm:ss");
        inputFormat.setLenient(false);
        for (int i = 0; i < list.size(); i++) {
            try{
                String date=list.get(i)+"";
                Pattern pattern=Pattern.compile("\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}");
                Matcher matcher=pattern.matcher(date);
                if(!matcher.matches()){
                    Assert.fail("Response date isn't as expected in format");
                }

                } catch(Exception e){
                Assert.fail("Response date isn't as expected in format");
            }

        }
    }






}
