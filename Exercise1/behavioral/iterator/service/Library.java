
package com.designpatterns.iterator.service;

import com.designpatterns.iterator.iterator.LibraryIterator;
import com.designpatterns.iterator.model.Book;
import com.designpatterns.iterator.model.BookIterator;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private final List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public LibraryIterator getIterator(String genre) {
        return new BookIterator(books, genre);
    }
}
