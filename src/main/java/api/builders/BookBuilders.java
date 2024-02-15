package api.builders;

import api.dto.request.book.AddBookDto;
import api.dto.request.book.IsbnDto;

import java.util.List;

public class BookBuilders {

    public AddBookDto defaultBookDtoBuilder() {
        return AddBookDto.builder()
                .userId("c754adde-0dda-4856-b45d-cce96993989c")
                .collectionOfIsbns(List.of(IsbnDto.builder().isbn("9781449325862").build()))
                .build();
    }

    public AddBookDto defaultBookDtoBuilder(String isbn) {
        return AddBookDto.builder()
                .userId("c754adde-0dda-4856-b45d-cce96993989c")
                .collectionOfIsbns(List.of(IsbnDto.builder().isbn(isbn).build()))
                .build();
    }
}
