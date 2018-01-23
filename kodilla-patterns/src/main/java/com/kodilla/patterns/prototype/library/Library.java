package com.kodilla.patterns.prototype.library;

import com.kodilla.patterns.prototype.Prototype;
import java.util.*;

import static java.util.stream.Collectors.joining;

public final class Library extends Prototype<Library> {
    private String name;
    private Set<Book> books = new HashSet<>();

    public Library(final String name) {
        validateString(name, "valueless name");

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        validateString(name, "valueless name");
        this.name = name;
    }

    public boolean addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("null book");
        }
        return books.add(book);
    }

    public Set<Book> getBooks() {
        return books;
    }

    public Library shallowCopy() throws CloneNotSupportedException {
        return clone();
    }

    public Library deepCopy() throws CloneNotSupportedException {
        Library clonedLibrary = clone();
        // Cloning of Book objects has no sense because they are immutable. book1.equals(book2)
        // means that book1 and book2 are and will be always the same book in the sense of publication.
        // So reference equality is sufficient.
        clonedLibrary.books = new HashSet<>(books);
        return clonedLibrary;
    }

    private void validateString(String arg, String message) {
        if (message == null) {
            message = "valueless String argument";
        }
        if (arg == null || arg.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        if (!name.equals(library.name)) return false;
        return books.equals(library.books);
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public String toString() {
        return "Library: '" + name + '\'' + '\n' +
                books.stream()
                    .map(Book::toString)
                    .collect(joining("\n\t", "\t", "\n"));
    }
}