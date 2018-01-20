package com.kodilla.patterns.prototype.library;

import java.time.LocalDate;

public final class Book {
    private final String title;
    private final String author;
    private final LocalDate publicationDate;

    public Book(final String title, final String author, final LocalDate publicationDate) {
        validate(title, author, publicationDate);

        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
    }

    private void validate(String title, String author, LocalDate publicationDate) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("valueless title");
        }
        if (author == null || author.isEmpty()) {
            throw new IllegalArgumentException("valueless author");
        }
        if (publicationDate == null) {
            throw new IllegalArgumentException("null publicationDate");
        }
    }

    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publicationDate=" + publicationDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        if (!title.equals(book.title)) return false;
        if (!author.equals(book.author)) return false;
        return publicationDate.equals(book.publicationDate);
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + author.hashCode();
        result = 31 * result + publicationDate.hashCode();
        return result;
    }
}