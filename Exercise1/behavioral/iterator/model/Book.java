package com.designpatterns.iterator.model;

public class Book {
    private String title;
    private String author;
    private String genre;
    private int publicationYear;

    public Book(String title, String author, String genre, int publicationYear) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publicationYear = publicationYear;
    }

    public String getDetails() {
        return "Title: " + title + ", Author: " + author + ", Genre: " + genre + ", Year: " + publicationYear;
    }

    public String getGenre() {
        return genre;
    }
}
