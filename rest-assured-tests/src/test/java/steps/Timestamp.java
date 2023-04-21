package steps;

import config.Settings;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;

import io.restassured.response.ResponseOptions;


import org.testng.Assert;
import utilities.*;




import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;


public class Timestamp {

    private ResponseOptions<Response> responseOptions;
    @Given("I perform GET Convert Unix TimeStamp to Date String with value {string}")
    @Given("I perform GET Convert Date String to Unix TimeStamp with value {string}")
    public void iPerformGETConvertUnixTimeStampToDateStringWithValue(String value) throws Exception {
        RestAssuredExtUtility restAssuredExtUtility = new RestAssuredExtUtility(
                value, "", APIConstant.ApiMethods.GET, "");

        responseOptions = restAssuredExtUtility.Execute();

    }

    @Given("I perform POST Convert Unix TimeStamp to Date String with value {string}")
    public void iPerformPOSTConvertUnixTimeStampToDateStringWithValue(String value) throws Exception {
        RestAssuredExtUtility restAssuredExtUtility = new RestAssuredExtUtility(
                value, "",  APIConstant.ApiMethods.POST, "");

        responseOptions = restAssuredExtUtility.Execute();
    }
    @Given("I perform DELETE Convert Unix TimeStamp to Date String with value {string}")
    public void iPerformDELETEConvertUnixTimeStampToDateStringWithValue(String value) throws Exception {
        RestAssuredExtUtility restAssuredExtUtility = new RestAssuredExtUtility(
                value, "",  APIConstant.ApiMethods.DELETE, "");

        responseOptions = restAssuredExtUtility.Execute();
    }
    @And("I assert value from date time")
    public void iAssertValueFromDateTime() {

        assertEquals(200, responseOptions.statusCode());
        Settings.BodyValue = responseOptions.getBody().asString();
    }

    @And("I assert value from unix timeStamp")
    public void iAssertValueFromUnixTimeStamp() throws InterruptedException {
        Thread.sleep(3000);
        assertEquals(200, responseOptions.statusCode());

        Settings.BodyValue = responseOptions.getBody().asString();
        Settings.BodyValue = (Settings.BodyValue.substring(1,Settings.BodyValue.length()-1));

        Assert.assertNotNull(Settings.BodyValue);
        Assert.assertTrue(Helpers.isValidDate(Settings.BodyValue));

    }

    @And("I assert invalid value")
    public void iAssertInvalidValue() throws InterruptedException {
        Thread.sleep(3000);
        assertEquals(200, responseOptions.statusCode());
        Settings.BodyValue = responseOptions.getBody().asString();
        Assert.assertTrue(Settings.BodyValue.contains("false"));
    }




}
