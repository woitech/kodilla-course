package com.kodilla.patterns.prototype.library;

import org.junit.Test;
import java.time.LocalDate;
import java.util.*;

import static org.junit.Assert.*;

public class LibraryTestSuite {
    @Test
    public void testGetBooksObtainedClonesBeforeOriginalChange() {
        // Given
        Library library = new Library("Public Library in Booktown");

        Set<Book> booksForBooktown = new HashSet<>();
        booksForBooktown.add(new Book("Pan Tadeusz", "Adam Mickiewicz", LocalDate.of(2015, 10, 10)));
        booksForBooktown.add(new Book("Potop", "Henryk Sienkiewicz", LocalDate.of(2016, 11, 11)));
        booksForBooktown.add(new Book("Granica", "Zofia Nałkowska", LocalDate.of(2017, 12, 12)));
        booksForBooktown.stream()
                .forEach(b -> library.addBook(b));

        // When
        Library shallowClonedLibrary = null;
        Library deepClonedLibrary = null;
        try {
            shallowClonedLibrary = library.shallowCopy();
            deepClonedLibrary = library.deepCopy();
        } catch (CloneNotSupportedException e) {
            fail("Exception is thrown: " + e);
        }

        // Then
        assertFalse(shallowClonedLibrary == library); // we have new reference
        assertFalse(deepClonedLibrary == library);
        assertEquals(shallowClonedLibrary, library); // but objects are equal
        assertEquals(deepClonedLibrary, library);
    }

    @Test
    public void testGetBooksObtainedClonesAfterOriginalChange() {
        // Given
        Library library = new Library("Public Library in Booktown");

        Set<Book> booksForBooktown = new HashSet<>();
        booksForBooktown.add(new Book("Pan Tadeusz", "Adam Mickiewicz", LocalDate.of(2015, 10, 10)));
        booksForBooktown.add(new Book("Potop", "Henryk Sienkiewicz", LocalDate.of(2016, 11, 11)));
        booksForBooktown.add(new Book("Granica", "Zofia Nałkowska", LocalDate.of(2017, 12, 12)));
        booksForBooktown.stream()
                .forEach(b -> library.addBook(b));

        Library shallowClonedLibrary = null;
        Library deepClonedLibrary = null;
        try {
            shallowClonedLibrary = library.shallowCopy();
            deepClonedLibrary = library.deepCopy();
        } catch (CloneNotSupportedException e) {
            fail("Exception is thrown: " + e);
        }

        // When
        library.addBook(new Book("Na luzie", "Doda Elektroda", LocalDate.of(2010, 9, 9)));

        // Then
        assertEquals(library, shallowClonedLibrary);
        assertNotEquals(library, deepClonedLibrary);
    }
}
