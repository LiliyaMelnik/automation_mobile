package api.endpoints;

public enum BookEndpoint {

    ADD_BOOK("/BookStore/v1/Books"),
    DELETE_BOOK("/BookStore/v1/Books?UserId=");

    private final String book;

    BookEndpoint(String book) {
        this.book = book;
    }

    public String getBook() {
        return book;
    }
}
