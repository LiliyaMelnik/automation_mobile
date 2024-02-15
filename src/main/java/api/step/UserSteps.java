package api.step;

import api.config.Requests;
import api.dto.response.get.GetUserDto;
import api.endpoints.UserEndpoints;

import static api.config.RequestService.requestWithToken;
import static api.config.ResponseService.ok;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class UserSteps {

    Requests requests = new Requests();

    public GetUserDto getUser() {
        return requests.get(requestWithToken(),
                UserEndpoints.GET_USER.getEndpoints() + "c754adde-0dda-4856-b45d-cce96993989c").then().spec(ok())
                .body(matchesJsonSchemaInClasspath("schemas/GetUserJsonSchema.json"))
                .extract().body().as(GetUserDto.class);
    }
}
