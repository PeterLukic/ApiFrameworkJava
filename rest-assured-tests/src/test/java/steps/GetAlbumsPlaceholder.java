package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import pojo.AlbumsPlaceholder;
import utilities.RestAssuredExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GetAlbumsPlaceholder {

    public static ResponseOptions<Response> response;

    @Given("I perform GET operation albums placeholder for {string}")
    public void iPerformGETOperationAlbumsPlaceholderFor(String url) throws Throwable {
        response = RestAssuredExtension.GetOps(url);
        //ExtentReport.getScenario().createNode(new GherkinKeyword("Given"), "I perform GET operation albums placeholder for: " + url);
    }
    @Then("I should see the placeholder albums title as {string}")
    public void iShouldSeeThePlaceholderAlbumsTitleAs(String title) throws Throwable {
        AlbumsPlaceholder albums = response.getBody().as(AlbumsPlaceholder.class);
        assertThat(albums.getTitle(), equalTo(title));
    }


}
