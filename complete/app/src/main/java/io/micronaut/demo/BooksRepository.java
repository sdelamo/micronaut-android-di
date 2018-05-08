package io.micronaut.demo;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton // <1>
public class BooksRepository implements BooksFetcher {

    @Override
    public void fetchBooks(OnBooksFetched onBooksFetched) {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Practical Grails 3"));
        bookList.add(new Book("Grails 3 - Step by Step"));
        if ( onBooksFetched != null ) {
            onBooksFetched.booksFetched(bookList);
        }
    }
}
