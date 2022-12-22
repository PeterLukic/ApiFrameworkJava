package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.testng.Assert;
import pojo.CommentsPlaceholder;
import utilities.RestAssuredExtension;

public class GetCommentsPlaceholder {

    public static ResponseOptions<Response> response;

    @Given("I perform GET operation comments placeholder for {string}")
    public void iPerformGETOperationCommentsPlaceholderFor(String url)throws Throwable{
        response = RestAssuredExtension.GetOps(url);

    }
    @Then("I should see the placeholder comments email as {string}")
    public void iShouldSeeThePlaceholderCommentsEmailAs(String email) throws Throwable{
        CommentsPlaceholder comments = response.getBody().as(CommentsPlaceholder.class);
        Assert.assertEquals(comments.getEmail(), email);

    }

}
