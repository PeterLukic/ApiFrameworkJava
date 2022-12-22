package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.hamcrest.core.IsNot;
import utilities.RestAssuredExtension;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class POSTProfileSteps {

    private static ResponseOptions<Response> response;
    @Given("I ensure to Perform POST operation for {string} with body as")
    public void iEnsureToPerformPOSTOperationForWithBodyAs(String url, DataTable table) {

        HashMap<String,String> body = new HashMap<>();
        body.put("id", "6");
        body.put("title", "API Testing course");
        body.put("author", "ExecuteAutomation");

        RestAssuredExtension.PostOpsWithBody(url, body);


    }

    @Given("I ensure to Perform POST for {string} with body as")
    public void iEnsureToPerformPOSTForWithBodyAs(String url, DataTable table) {

        List<Map<String,String>> rows = table.asMaps(String.class, String.class);
        System.out.println("id - " + rows.get(0).get("id"));
        System.out.println("title - " + rows.get(0).get("title"));
        System.out.println("author - " + rows.get(0).get("author"));
    }

    @And("I Perform DELETE operation for {string}")
    public void iPerformDELETEOperationFor(String url, DataTable table) {

        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("postid", "6");

        RestAssuredExtension.DeleteOpsWithPathParams(url, pathParams);


    }
    @Then("I {string} see the body with title as {string}")
    public void iSeeTheBodyWithTitleAs(String condition, String title) {
        if (condition.equalsIgnoreCase("should not"))
            assertThat(response.getBody().jsonPath().get("title"), IsNot.not(title));
        else
            assertThat(response.getBody().jsonPath().get("title"), equalTo(title));
    }



    @And("I perform GET operation with path parameter for {string}")
    public void iPerformGETOperationWithPathParameterFor(String url, DataTable table) {

        List<Map<String,String>> rows = table.asMaps(String.class, String.class);


        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("postid",  rows.get(0).get("postid"));

        response = RestAssuredExtension.GetWithPathParams(url, pathParams);

    }



}
