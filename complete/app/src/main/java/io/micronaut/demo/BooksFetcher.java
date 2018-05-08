package io.micronaut.demo;

public interface BooksFetcher {
    void fetchBooks(OnBooksFetched onBooksFetched);
}
