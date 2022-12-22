package steps;


import com.aventstack.extentreports.GherkinKeyword;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import pojo.Posts;
import utilities.RestAssuredExtension;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class GetPostSteps {

    public static ResponseOptions<Response> response;
    public static String token;

    @Given("I perform GET operation for {string}")
    public void iPerformGETOperationFor(String url) throws Throwable {
        response = RestAssuredExtension.GetOps(url);
        //ExtentReport.getScenario().createNode(new GherkinKeyword("Given"), "I perform GET operation for {string}");
    }

    @Given("I perform POST operation for {string}")
    public void iPerformPOSTOperationFor(String arg0) {
        BDDStyleMethod.PerformPOSTWithBodyParameter();
    }

    @Given("I perform POST operation for {string} with body {string} as {string} and {string} as {string}")
    public void iPerformPOSTOperationForWithBodyAsAndAs(String url, String keyName, String valueName, String keyProfile, String valueProfile) {

        //Set Body
        HashMap<String, String> body = new HashMap<>();
        body.put(keyName, valueName);

        //Path params
        HashMap<String, String> pathParams = new HashMap<>();
        pathParams.put(keyProfile, valueProfile);

        //Perform post operation
        response = RestAssuredExtension.PostOpsWithBodyAndPathParams(url, pathParams, body);

    }


    @Given("I perform authentication operation for {string} with body")
    public void iPerformAuthenticationOperationForWithBody(String url, DataTable table) {

        List<Map<String,String>> rows = table.asMaps(String.class, String.class);

        HashMap<String,String> body = new HashMap<>();
        body.put("email", rows.get(0).get("email"));
        body.put("password", rows.get(0).get("password"));

 /*       LoginBody loginBody = new LoginBody();
        loginBody.setEmail(rows.get(0).get("email"));
        loginBody.setPassword(rows.get(0).get("password"));*/


        response  = RestAssuredExtension.PostOpsWithBody(url, body);

/*        RestAssuredExtUtility restAssuredExtUtility = new RestAssuredExtUtility(url, APIConstant.ApiMethods.POST, token);

        token = restAssuredExtUtility.Authenticate(loginBody);*/
    }

    @Given("I perform GET operation for {string} with token")
    public void iPerformGETOperationForWithToken(String url) {
        response = RestAssuredExtension.GetOpsWithToken(url, response.getBody().jsonPath().get("access_token"));
    }

    @Then("^I should see the author name as \"([^\"]*)\"$")
    public void iShouldSeeTheAuthorNameAs(String authorName) throws Throwable {

        Posts posts = response.getBody().as(Posts.class);
        assertThat(posts.getAuthor(), equalTo(authorName));
    }


    @Then("I should see the author name as {string} with json validation")
    public void iShouldSeeTheAuthorNameAsWithJsonValidation(String authorName) {

        String responseBody = response.getBody().asString();
        System.out.println(responseBody);
        assertThat(responseBody, matchesJsonSchemaInClasspath("post.json"));
        System.out.println("------------------------------------------------------------");
        System.out.println(matchesJsonSchemaInClasspath("post.json"));
    }

    @Then("I should see the key {string} name as {string}")
    public void iShouldSeeTheKeyNameAs(String keyName, String authorName) {
        assertThat(response.getBody().jsonPath().get(keyName), hasItem(authorName));
    }

    @Then("I should see the author names")
    public void iShouldSeeTheAuthorNames() {
        BDDStyleMethod.PerformContainsCollection();
    }

    @Then("I should see verify GET Parameter")
    public void iShouldSeeVerifyGETParameter() {
        BDDStyleMethod.PerformPathParameter();
    }

    @Then("I should see verify queryParam GET Parameter")
    public void iShouldSeeVerifyQueryParamGETParameter() {
        BDDStyleMethod.PerformQueryParameter();
    }


    @Then("I should see the body has name as {string}")
    public void iShouldSeeTheBodyHasNameAs(String valueName) {
        assertThat(response.getBody().jsonPath().get("name"), equalTo(valueName));
    }



}
