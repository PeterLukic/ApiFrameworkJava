package steps;

import com.aventstack.extentreports.GherkinKeyword;
import config.Settings;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import pojo.PostsPlaceholder;
import utilities.APIConstant;
import utilities.RestAssuredExtUtility;
import utilities.RestAssuredExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GetPostsPlaceholder {

    public static ResponseOptions<Response> response;
    @Given("I perform GET operation posts placeholder for {string}")
    public void iPerformGETOperationPostsPlaceholderFor(String url) throws Throwable{
        response = RestAssuredExtension.GetOps(url);


        RestAssuredExtUtility restAssuredExtUtility = new RestAssuredExtUtility(Settings.Url, "app/coi/", APIConstant.ApiMethods.POST, "");
    }

    @Then("I should see the placeholder posts title as {string}")
    public void iShouldSeeThePlaceholderPostsTitleAs(String title) throws Throwable {
        PostsPlaceholder posts = response.getBody().as(PostsPlaceholder.class);
        assertThat(posts.getTitle(), equalTo(title));
    }



}
