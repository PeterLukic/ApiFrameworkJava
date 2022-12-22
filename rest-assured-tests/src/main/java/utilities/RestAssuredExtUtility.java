package utilities;


import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestAssuredExtUtility {

    private RequestSpecBuilder builder = new RequestSpecBuilder();
    private String method;
    private String url;

    public RestAssuredExtUtility(String url, String uri, String method, String token) throws Exception {

        this.url = url + uri;
        this.method = method;

        switch (token) {
            case "":
                RestAssured.useRelaxedHTTPSValidation();
                break;
            case "Basic":
                builder.log(LogDetail.ALL).addHeader("Authorization", "Basic " + "YXBpY2xpZW50QGktdGM6YXBpLjEyMzQ1Ng==");
                break;
            case "Bearer":
                builder.log(LogDetail.ALL).addHeader("Authorization", "Bearer " + "Token");
                break;
            default:
                throw new Exception(token +  " not found.");
        }


    }

    private ResponseOptions<Response> ExecuteAPI() {
        RequestSpecification requestSpecification = builder.build();
        RequestSpecification request = given();
        request.contentType(ContentType.JSON);
        //request.contentType(ContentType.XML);
        request.spec(requestSpecification);

        if (this.method.equalsIgnoreCase(APIConstant.ApiMethods.POST))
            return request.post(this.url);
        if (this.method.equalsIgnoreCase(APIConstant.ApiMethods.PUT))
            return request.put(this.url);
        if (this.method.equalsIgnoreCase(APIConstant.ApiMethods.PATCH))
            return request.patch(this.url);
        else if (this.method.equalsIgnoreCase(APIConstant.ApiMethods.DELETE))
            return request.delete(this.url);
        else if (this.method.equalsIgnoreCase(APIConstant.ApiMethods.GET))
            return request.get(this.url);
        return null;

    }


    public String Authenticate(Object body) {
        builder.setBody(body);
        return ExecuteAPI().getBody().jsonPath().get("access_token");
    }

    public ResponseOptions<Response> ExecuteWithPathParamsAndBody(Map<String, String> pathParams, Map<String, String> body) {
        builder.setBody(body);
        builder.addPathParams(pathParams);
        return ExecuteAPI();
    }

    public ResponseOptions<Response> ExecuteWithQueryParams(Map<String, String> queryPath) {
        builder.addQueryParams(queryPath);
        return ExecuteAPI();
    }

    public ResponseOptions<Response> ExecuteWithPathParams(Map<String, String> pathParams) {
        builder.addPathParams(pathParams);
        return ExecuteAPI();
    }
}
