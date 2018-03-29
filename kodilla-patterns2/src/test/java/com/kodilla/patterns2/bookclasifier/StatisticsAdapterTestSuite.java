package com.kodilla.patterns2.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.StatisticsAdapter;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class StatisticsAdapterTestSuite {
    @Test
    public void testPublicationYearMedianOddBooksNumber() {
        // Given
        Set<Book> bookOfTypeA = new HashSet<>();
        bookOfTypeA.add(new Book("Author 1", "Title 1", 2017, "Signature 1"));
        bookOfTypeA.add(new Book("Author 2", "Title 2", 1979, "Signature 2"));
        bookOfTypeA.add(new Book("Author 3", "Title 3", 2018, "Signature 3"));
        bookOfTypeA.add(new Book("Author 4", "Title 4", 2015, "Signature 4"));
        bookOfTypeA.add(new Book("Author 5", "Title 5", 2000, "Signature 5"));

        // When
        int median = new StatisticsAdapter().publicationYearMedian(bookOfTypeA);

        // Then
        assertEquals(2015, median);
    }

    @Test
    public void testPublicationYearMedianEvenBooksNumber() {
        // Given
        Set<Book> bookOfTypeA = new HashSet<>();
        bookOfTypeA.add(new Book("Author 1", "Title 1", 2017, "Signature 1"));
        bookOfTypeA.add(new Book("Author 2", "Title 2", 1979, "Signature 2"));
        bookOfTypeA.add(new Book("Author 3", "Title 3", 2000, "Signature 3"));
        bookOfTypeA.add(new Book("Author 4", "Title 4", 2018, "Signature 4"));

        // When
        int median = new StatisticsAdapter().publicationYearMedian(bookOfTypeA);

        // Then
        assertEquals(2008, median); // (2000 + 2017) / 2 == 2008
    }

    @Test
    public void testPublicationYearMedianOneBook() {
        // Given
        Set<Book> bookOfTypeA = new HashSet<>();
        bookOfTypeA.add(new Book("Author 1", "Title 1", 2017, "Signature 1"));

        // When
        int median = new StatisticsAdapter().publicationYearMedian(bookOfTypeA);

        // Then
        assertEquals(2017, median);
    }
}
