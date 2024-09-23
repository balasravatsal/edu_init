package com.designpatterns.iterator;

import com.designpatterns.iterator.iterator.LibraryIterator;
import com.designpatterns.iterator.model.Book;
import com.designpatterns.iterator.service.Library;

public class Client {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(new Book("1984", "George Orwell", "Dystopian", 1949));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "Classic", 1960));
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "Classic", 1925));
        library.addBook(new Book("Brave New World", "Aldous Huxley", "Science Fiction", 1932));

        // Filter books by genre
        LibraryIterator iterator = library.getIterator("Classic");

        System.out.println("Books in the Classic genre:");
        while (iterator.hasNext()) {
            Book book = iterator.next();
            System.out.println(book.getDetails());
        }
    }
}