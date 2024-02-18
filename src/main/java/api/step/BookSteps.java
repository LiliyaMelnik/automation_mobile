package api.step;

import api.builders.BookBuilders;
import api.config.Requests;
import api.dto.response.book.BookDto;
import api.endpoints.BookEndpoint;

import static api.config.RequestService.requestWithToken;
import static api.config.ResponseService.create;
import static api.config.ResponseService.delete;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class BookSteps {

    Requests requests = new Requests();

    public BookDto addBookToUser() {
        return requests.post(requestWithToken(), new BookBuilders().defaultBookDtoBuilder(), BookEndpoint.ADD_BOOK.getBook())
                .then().spec(create()).body(matchesJsonSchemaInClasspath("schemas/AddBookJsonSchema.json"))
                .extract().body().as(BookDto.class);
    }

    public BookDto addBookToUser(String isbn) {
        return requests.post(requestWithToken(), new BookBuilders().defaultBookDtoBuilder(isbn), BookEndpoint.ADD_BOOK.getBook())
                .then().spec(create()).extract().body().as(BookDto.class);
    }

    public void deleteBook() {
        requests.delete(requestWithToken(), BookEndpoint.DELETE_BOOK.getBook() + "c754adde-0dda-4856-b45d-cce96993989c")
                .then().spec(delete());
    }

}
