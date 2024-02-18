package api.config;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static api.config.RequestService.request;
import static api.utils.Utils.toJson;
import static io.restassured.RestAssured.given;

public class Requests {

    public Response post(Object body, String endpoint) {
        return given()
                .spec(request())
                .body(toJson(body))
                .when()
                .post(endpoint);
    }

    public Response post(RequestSpecification specRequest, Object body, String endpoint) {
        return given()
                .spec(specRequest)
                .body(toJson(body))
                .when()
                .post(endpoint);
    }

    public Response get(RequestSpecification specRequest, String endpoint) {
        return given()
                .spec(specRequest)
                .when()
                .get(endpoint);
    }

    public Response delete(RequestSpecification specification, String endpoint) {
        return given()
                .spec(specification)
                .when()
                .delete(endpoint);
    }
}
