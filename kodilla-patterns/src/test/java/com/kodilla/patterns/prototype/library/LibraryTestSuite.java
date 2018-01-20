package com.kodilla.patterns.prototype.library;

import org.junit.Test;
import java.time.LocalDate;
import java.util.*;

import static org.junit.Assert.*;

public class LibraryTestSuite {
    @Test
    public void testGetBooks() {
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
            shallowClonedLibrary.setName("Accurate follower of " + library.getName());
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("Public Library in Readerstown");
        } catch (CloneNotSupportedException e) {
                System.err.println(e);
        }

        Set<Book> libraryBooks = library.getBooks();
        Set<Book> shallowClonedLibraryBooks = shallowClonedLibrary.getBooks();
        Set<Book> deepClonedLibraryBooks = deepClonedLibrary.getBooks();

        // Then
        assertEquals(booksForBooktown, libraryBooks);

        assertNotSame(library, shallowClonedLibrary);
        assertSame(libraryBooks, shallowClonedLibraryBooks);

        assertNotSame(library, deepClonedLibrary);
        assertNotSame(libraryBooks, deepClonedLibraryBooks);
        assertEquals(libraryBooks, deepClonedLibraryBooks);
        // End of test.

        // Demonstration:
        // When
        library.addBook(new Book("Na luzie", "Doda Elektroda", LocalDate.of(2010, 9, 9)));

        // Then
        System.out.println(library);
        System.out.println(shallowClonedLibrary);
        System.out.println(deepClonedLibrary);
    }
}
