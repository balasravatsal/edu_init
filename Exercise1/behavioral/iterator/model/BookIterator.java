
package com.designpatterns.iterator.model;

import com.designpatterns.iterator.iterator.LibraryIterator;
import com.designpatterns.iterator.model.Book;

import java.util.List;

public class BookIterator implements LibraryIterator {
    private List<Book> books;
    private String genreFilter;
    private int position;

    public BookIterator(List<Book> books, String genreFilter) {
        this.books = books;
        this.genreFilter = genreFilter;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        while (position < books.size()) {
            if (books.get(position).getGenre().equalsIgnoreCase(genreFilter)) {
                return true;
            }
            position++;
        }
        return false;
    }

    @Override
    public Book next() {
        return books.get(position++);
    }
}
