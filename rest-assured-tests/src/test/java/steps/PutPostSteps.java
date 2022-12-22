package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import utilities.RestAssuredExtension;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;

public class PutPostSteps {

    @And("I Perform PUT operation for {string}")
    public void iPerformPUTOperationFor(String url, DataTable table) {

        List<Map<String,String>> rows = table.asMaps(String.class, String.class);
/*        System.out.println("id - " + rows.get(0).get("id"));
        System.out.println("title - " + rows.get(0).get("title"));
        System.out.println("author - " + rows.get(0).get("author"));*/


        HashMap<String,String> body = new HashMap<>();
        body.put("id", rows.get(0).get("id"));
        body.put("title", rows.get(0).get("title"));
        body.put("author", rows.get(0).get("author"));

        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("postid", rows.get(0).get("id"));

        RestAssuredExtension.PUTOpsWithBodyAndPathParams(url, body, pathParams);
    }


}
