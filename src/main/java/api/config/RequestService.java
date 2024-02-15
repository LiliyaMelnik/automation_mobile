package api.config;

import api.dto.response.UserDto;
import api.endpoints.UserEndpoints;
import api.builders.UserBuilders;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

import java.util.List;

import static api.config.PropertyService.getPropertyFromApiFile;
import static api.config.ResponseService.ok;
import static io.restassured.filter.log.LogDetail.HEADERS;
import static io.restassured.filter.log.LogDetail.METHOD;
import static io.restassured.filter.log.LogDetail.PARAMS;
import static io.restassured.filter.log.LogDetail.URI;
import static java.lang.String.format;

public class RequestService {

    private static final String APPLICATION_JSON = "application/json";
    private static final String CONTENT = "Content-Type";
    private static final String URL = String.valueOf(getPropertyFromApiFile("url"));

    public static RequestSpecification request() {
        return new RequestSpecBuilder()
                .addFilters(List.of(new RequestLoggingFilter(METHOD),
                        new RequestLoggingFilter(URI),
                        new RequestLoggingFilter(HEADERS),
                        new RequestLoggingFilter(PARAMS)))
                .setBaseUri(URL)
                .addHeader(CONTENT, APPLICATION_JSON)
                .build();
    }

    public static RequestSpecification requestWithToken() {
        return new RequestSpecBuilder()
                .addFilters(List.of(new RequestLoggingFilter(METHOD),
                        new RequestLoggingFilter(URI),
                        new RequestLoggingFilter(PARAMS),
                        new ResponseLoggingFilter()))
                .setBaseUri(URL)
                .addHeader(CONTENT, APPLICATION_JSON)
                .addHeader("Authorization", format("Bearer %s", getToken()))
                .build();
    }

    public static String getToken() {
        return new Requests().post(new UserBuilders().userDefaultBuilder(),
                UserEndpoints.GENERATE_TOKEN.getEndpoints()).then().spec(ok()).extract().body().as(UserDto.class).getToken();
    }

}
