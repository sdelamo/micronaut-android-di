package io.micronaut.demo;

import java.util.List;

public interface OnBooksFetched {
    void booksFetched(List<Book> books);
}
