package api.tools;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specification {
    public static RequestSpecification requestSpecification(String url) {
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setContentType("application/json")
                .build();
    }

    public static ResponseSpecification responseSpecification200() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }


    public static void installSpecification(ResponseSpecification response, RequestSpecification request) {
        RestAssured.requestSpecification = request;
        RestAssured.responseSpecification = response;

    }

}
