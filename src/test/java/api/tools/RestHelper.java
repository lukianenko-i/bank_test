package api.tools;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestHelper {
    public static Response get(String end){
        return RestAssured
                .given()
                .when()
                .log().all()
                .get(end)
                .then()
                .log().all()
                .extract().response();


    }
}
