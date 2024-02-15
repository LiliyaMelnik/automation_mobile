package api.test;

import api.exceptions.BookNotFoundException;
import api.step.BookSteps;
import api.step.UserSteps;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class GenerateTokenTest {

    private final String TITLE = "Designing Evolvable Web APIs with ASP.NET";
    private final UserSteps steps = new UserSteps();
    private final BookSteps bookSteps = new BookSteps();

    @Test
    void shouldBeAddedBook() {
        bookSteps.addBookToUser();
        var responseUser = steps.getUser();
        assertThat(responseUser.getBooks().get(0).getTitle()).isEqualTo("Git Pocket Guide");
    }

    @Test
    void shouldBeAddedBooks() {
//        bookSteps.addBookToUser("9781449325862");
//        bookSteps.addBookToUser("9781449331818");
//        bookSteps.addBookToUser("9781449337711");
        var responseUser = steps.getUser();

        var book = responseUser.getBooks().stream().filter(type -> type.getTitle().equals(TITLE)).findFirst()
                .orElseThrow(() -> new BookNotFoundException("The book is not found"));


        assertThat(book.getTitle()).isEqualTo(TITLE);

    }

//    @Test
//    void deleteBook() {
//        bookSteps.deleteBook();
//    }

    @AfterMethod
    void deleteBooks() {
        bookSteps.deleteBook();
    }
}
